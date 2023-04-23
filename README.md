# NPS 프로젝트
이 프로젝트는 고객 만족도 측정에 사용되는 Net Promoter Score(NPS)를 계산하기 위한 Spring boot 프로젝트입니다.

## 개발 환경
- Spring Boot 2.4.4
- Java 11
- MySQL 8.0.23
- Gradle 7.6.1
## 실행 방법
- MySQL을 설치하고 실행합니다.
- npsproject.sql 파일을 이용하여 데이터베이스와 테이블을 생성합니다.
- application.properties 파일을 열고 데이터베이스 접속 정보를 수정합니다.
- Gradle을 사용하여 어플리케이션을 빌드합니다.
- java -jar 명령어를 사용하여 빌드한 Jar 파일을 실행합니다.

## 기능
- 고객 정보 등록, 조회, 수정, 삭제
- 고객 만족도 정보 등록, 조회
- 전체 고객 수, NPS 점수 계산
- NPS = 추천 고객의 % – 비추천 고객의 %

## API 문서
- API 문서는 Swagger UI를 이용하여 제공됩니다. /swagger-ui.html 경로로 접속하여 확인할 수 있습니다.

## Demo
- [Swagger UI](http://43.200.217.151:8000/swagger-ui/index.html/journey-nps-controller/calculateNps)
(임의 1000명의 고객을 생성, 점수별 카운트 및 NPS점수 계산)

## 라이센스
MIT License
