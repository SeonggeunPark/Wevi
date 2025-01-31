pipeline {
    agent any

    environment {
        BRANCH_NAME = "${GIT_BRANCH}"
        NODE_VERSION = 'node18'
        DEPLOY_PATH = '/home/ubuntu/nginx/html'
        JAVA_VERSION = 'jdk17'
        APP_NAME = 'jenkins-test'
        DOCKER_IMAGE = 'jenkins-test:latest'
        // Mattermost 설정
        MATTERMOST_WEBHOOK = credentials('mattermost-webhook')
        MATTERMOST_CHANNEL = '#jenkins-alerts'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    echo "현재 브랜치: ${BRANCH_NAME}"
                    notifyMattermost("STARTED", "파이프라인 시작")
                }
            }
        }

        stage('Backend Build & Deploy') {
            when {
                expression { BRANCH_NAME == 'origin/back' }
            }
            tools {
                jdk "${JAVA_VERSION}"
            }
            steps {
                dir('backend') {
                    script {
                        sh '''
                            echo "===== Build Environment ====="
                            echo "JDK Version:"
                            java --version
                            echo "Docker Version:"
                            docker --version
                            echo "Current Directory:"
                            pwd
                            ls -la
                        '''

                        // Prepare Environment
                        sh '''
                            rm -rf src/main/resources
                            mkdir -p src/main/resources
                            chmod 777 src/main/resources
                        '''

                        // 시크릿 파일 설정 부분 (필요시 주석 해제)
                        // withCredentials([
                        //     file(credentialsId: 'prod-yaml', variable: 'prodFile'),
                        //     file(credentialsId: 'secret-yaml', variable: 'secretFile')
                        // ]) 
                        // sh '''
                        //     cp "$prodFile" src/main/resources/application-prod.yml
                        //     cp "$secretFile" src/main/resources/application-secret.yml
                        //     chmod 644 src/main/resources/application-*.yml
                        // '''

                        // Gradle 빌드
                        sh '''
                            chmod +x gradlew
                            ./gradlew clean build -x test --no-daemon
                        '''
                        
                        // Docker 배포
                        sh '''
                            docker rm -f ${APP_NAME} || true
                            docker rmi ${DOCKER_IMAGE} || true
                            docker build -t ${DOCKER_IMAGE} .
                            docker run -d \
                                --name ${APP_NAME} \
                                --restart unless-stopped \
                                -p 8080:8080 \
                                ${DOCKER_IMAGE}
                        '''
                    }
                }
            }
            post {
                success {
                    script {
                        notifyMattermost("SUCCESS", "백엔드 빌드 및 배포 성공")
                    }
                }
                failure {
                    script {
                        notifyMattermost("FAILURE", "백엔드 빌드 및 배포 실패")
                    }
                }
            }
        }

        stage('Frontend Build & Deploy') {
            when {
                expression { BRANCH_NAME == 'origin/front' }
            }
            tools {
                nodejs "${NODE_VERSION}"
            }
            steps {
                dir('frontend') {
                    script {
                        sh '''
                            echo "===== Build Environment ====="
                            echo "Node Version:"
                            node --version
                            echo "NPM Version:"
                            npm --version
                            echo "Current Directory:"
                            pwd
                            ls -la
                        '''

                        sh '''
                            echo "===== Starting Build Process ====="
                            rm -rf node_modules
                            npm install
                            CI=false npm run build
                        '''
                        
                        sh '''
                            echo "===== Starting Deployment ====="
                            echo "Cleaning deployment directory..."
                            rm -rf ${DEPLOY_PATH}/*
                            
                            echo "Copying build files..."
                            cp -r build/* ${DEPLOY_PATH}/
                            
                            echo "Verifying deployment..."
                            ls -la ${DEPLOY_PATH}
                        '''
                    }
                }
            }
            post {
                success {
                    script {
                        notifyMattermost("SUCCESS", "프론트엔드 빌드 및 배포 성공")
                    }
                }
                failure {
                    script {
                        notifyMattermost("FAILURE", "프론트엔드 빌드 및 배포 실패")
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            script {
                notifyMattermost("SUCCESS", "전체 파이프라인 성공적으로 완료")
            }
        }
        failure {
            script {
                notifyMattermost("FAILURE", "파이프라인 실패")
            }
        }
    }
}

// Mattermost 알림 함수
def notifyMattermost(String status, String message) {
    def color = status == 'SUCCESS' ? '#36a64f' : status == 'FAILURE' ? '#dc3545' : '#ffc107'
    def payload = JsonOutput.toJson([
        channel: MATTERMOST_CHANNEL,
        username: 'Jenkins',
        text: "**${env.JOB_NAME}** - ${message}",
        attachments: [[
            fallback: "${status}: ${message}",
            color: color,
            fields: [
                [
                    title: "Status",
                    value: status,
                    short: true
                ],
                [
                    title: "Branch",
                    value: BRANCH_NAME,
                    short: true
                ],
                [
                    title: "Build Number",
                    value: "#${env.BUILD_NUMBER}",
                    short: true
                ]
            ]
        ]]
    ])

    sh """
        curl -X POST -H 'Content-Type: application/json' --data '${payload}' ${MATTERMOST_WEBHOOK}
    """
}