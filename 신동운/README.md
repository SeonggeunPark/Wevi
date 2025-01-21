# 12기 대전2반 B208 신동운

## 부트캠프 주간
- 아이디어 해커톤
- Spring Security 학습

## 1주차 
1. 아이디어 구상
2. 아이디어 회의
3. 요구사항 정의서 작성
4. Security 학습
5. Docker 학습습
---

Docker 강의 정리

1. Docker란?

컨테이너 기술을 활용하여 애플리케이션을 패키징, 배포 및 실행하는 플랫폼.

컨테이너는 애플리케이션과 그 실행에 필요한 모든 것을 포함한 독립된 실행 환경.

주요 장점: 경량화, 이식성, 빠른 배포.

2. Docker의 구성 요소

(1) Docker Engine

Docker 데몬: 컨테이너 관리 역할 수행.

Docker CLI: 명령줄 인터페이스로 Docker와 상호작용.

REST API: Docker와 프로그램적으로 상호작용 가능.

(2) 이미지 (Image)

애플리케이션 실행에 필요한 설정 및 종속성이 포함된 템플릿.

계층적 구조를 가짐: 이전 계층 재사용 가능.

(3) 컨테이너 (Container)

이미지를 실행한 상태의 인스턴스.

가벼운 가상 환경 제공.

(4) Docker Hub

Docker 이미지를 공유하기 위한 중앙 저장소.

공개 및 개인 저장소 지원.

3. Docker 설치

(1) 주요 지원 OS

Windows, macOS, Linux.

(2) 설치 과정

Docker 공식 웹사이트 방문.

운영체제에 맞는 Docker Desktop 다운로드 및 설치.

Docker 설치 확인:

docker --version

4. 주요 명령어

(1) 이미지 관련

이미지 검색:

docker search [이미지 이름]

이미지 다운로드:

docker pull [이미지 이름]

로컬 이미지 목록:

docker images

(2) 컨테이너 관련

컨테이너 실행:

docker run [옵션] [이미지 이름]

실행 중인 컨테이너 확인:

docker ps

정지된 컨테이너 포함 확인:

docker ps -a

컨테이너 중지:

docker stop [컨테이너 ID]

컨테이너 삭제:

docker rm [컨테이너 ID]

5. Dockerfile

이미지를 생성하기 위한 설정 파일.

기본 구조:

# 베이스 이미지
FROM [베이스 이미지]

# 메타데이터
LABEL maintainer="[유지보수자 이름]"

# 의존성 설치
RUN [명령어]

# 작업 디렉토리 설정
WORKDIR [경로]

# 애플리케이션 복사
COPY [소스] [대상]

# 실행 명령어
CMD ["실행 파일", "옵션"]

이미지 빌드:

docker build -t [이미지 이름] .

6. Docker Compose

여러 컨테이너를 정의하고 실행할 수 있는 도구.

YAML 파일 형식으로 구성.

(1) 기본 구조

version: '3.8'
services:
  app:
    image: [이미지 이름]
    ports:
      - "8080:80"
    volumes:
      - ./app:/usr/src/app

(2) 주요 명령어

서비스 실행:

docker-compose up

서비스 중지:

docker-compose down

7. 실전 활용 예제

(1) 간단한 웹 서버 실행

Nginx 이미지 다운로드:

docker pull nginx

컨테이너 실행:

docker run -d -p 8080:80 nginx

브라우저에서 http://localhost:8080 확인.

(2) Python 애플리케이션 컨테이너화

프로젝트 구조:

myapp/
├── app.py
└── Dockerfile

app.py:

from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return "Hello, Docker!"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)

Dockerfile:

FROM python:3.8-slim

WORKDIR /app

COPY . /app

RUN pip install flask

CMD ["python", "app.py"]

이미지 빌드:

docker build -t my-python-app .

컨테이너 실행:

docker run -d -p 5000:5000 my-python-app

브라우저에서 http://localhost:5000 확인.


dkdkdkdk