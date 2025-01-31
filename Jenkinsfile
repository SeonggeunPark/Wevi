pipeline {
    agent any

    environment {
        BRANCH_NAME = "${GIT_BRANCH}"
        NODE_VERSION = 'node18'
        DEPLOY_PATH = '/home/ubuntu/nginx/html'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    echo "현재 브랜치: ${BRANCH_NAME}"
                    echo "v2"
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