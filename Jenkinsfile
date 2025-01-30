pipeline {
    agent any

    environment {
        BRANCH_NAME = "${GIT_BRANCH}"
        NODE_VERSION = 'node18'  // Jenkins에서 설정한 NodeJS 버전명
        JAVA_VERSION = 'jdk17'    // Jenkins에서 설정한 JDK 버전명
        DEPLOY_PATH = '/home/ubuntu/nginx/html'  // Front 배포 경로 (Nginx)
        APP_NAME = 'jenkins-test'  // 백엔드 컨테이너명
        DOCKER_IMAGE = 'jenkins-test:latest'  // 백엔드 Docker 이미지명
        GRADLE_OPTS = '-Dorg.gradle.jvmargs="-Xmx256m"'  // Gradle 메모리 제한
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

        stage('Frontend Build & Deploy') {
            when {
                expression { BRANCH_NAME == 'origin/front' }  // front 브랜치일 때 실행
            }
            tools {
                nodejs "${NODE_VERSION}"
            }
            steps {
                script {
                    sh '''
                        node --version
                        npm --version
                        rm -rf node_modules
                        npm install
                        npm run build
                    '''
                    
                    // 기존 파일 제거 후 새 빌드 배포
                    sh '''
                        rm -rf ${DEPLOY_PATH}/*
                        cp -r dist/* ${DEPLOY_PATH}/
                    '''
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}