pipeline {
    agent any

    environment {
        BRANCH_NAME = "${GIT_BRANCH}"
        NODE_VERSION = 'node20'
        DEPLOY_PATH = '/home/ubuntu/nginx/html'
        DEPLOY_PATH = '/home/ubuntu/nginx/html' // Front 배포 경로 (Nginx)
        JAVA_VERSION = 'jdk17' // Jenkins에서 설정한 JDK 버전명
        DOCKER_IMAGE = 'jenkins-test:latest' // 백엔드 Docker 이미지명
        GRADLE_OPTS = '-Dorg.gradle.jvmargs="-Xmx256m"'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    echo "현재 브랜치: ${BRANCH_NAME}"
                }
            }
        }

        stage('Backend Build & Deploy') {
            when {
                expression { BRANCH_NAME == 'origin/back' }  // back 브랜치일 때 실행
            }
            tools {
                jdk "${JAVA_VERSION}"
            }
            steps {
                dir('backend') {
                    script {
                        sh '''
                            chmod +x gradlew
                            ./gradlew clean build -x test --no-daemon --max-workers 2 -Dorg.gradle.jvmargs="-Xmx256m"
                        '''
                        
                        // 기존 컨테이너 제거 및 새 컨테이너 배포
                        sh '''
                            docker rm -f ${APP_NAME} || true
                            docker rmi ${DOCKER_IMAGE} || true
                            docker build --memory=512m --memory-swap=512m -t ${DOCKER_IMAGE} .
                            docker run -d \
                                --name ${APP_NAME} \
                                --restart unless-stopped \
                                --memory=512m \
                                --memory-swap=512m \
                                -p 8080:8080 \
                                ${DOCKER_IMAGE}
                        '''
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
                        // 빌드 전 상태 출력
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

                        // 빌드 프로세스
                        sh '''
                            echo "===== Starting Build Process ====="
                            rm -rf node_modules
                            npm install
                            CI=false npm run build
                        '''
                        
                        // 배포
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
                    echo '프론트엔드 빌드 및 배포 성공'
                }
                failure {
                    echo '프론트엔드 빌드 및 배포 실패'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo '파이프라인 성공'
        }
        failure {
            echo '파이프라인 실패'
        }
    }
}