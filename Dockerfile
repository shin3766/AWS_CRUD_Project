# 기본 이미지
FROM openjdk:17-jdk-slim

WORKDIR /app

ARG JAR_FILE=build/libs/AWS_CRUD_Practice-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} AWS_CRUD_Practice.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/AWS_CRUD_Practice.jar"]
