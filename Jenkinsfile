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
                dir('frontend') {  // frontend 디렉토리로 이동
                    script {
                        sh '''
                            node --version
                            npm --version
                            rm -rf node_modules
                            npm install
                            CI=false npm run build  # React 빌드 시 경고를 에러로 처리하지 않도록 설정
                        '''
                        
                        // 기존 파일 제거 후 새 빌드 배포
                        sh '''
                            rm -rf ${DEPLOY_PATH}/*
                            cp -r build/* ${DEPLOY_PATH}/  # dist를 build로 변경
                        '''
                    }
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