# 기반 이미지
FROM node:18-alpine

# 작업 디렉토리 설정
WORKDIR /usr/src/app

# 빌드된 파일들을 이미지로 복사
COPY package*.json .

ADD . .

RUN npm install

# 애플리케이션에 할당할 포트
EXPOSE 5173
#EXPOSE 3000

# 애플리케이션 실행 명령어
CMD ["npm", "run", "dev"]