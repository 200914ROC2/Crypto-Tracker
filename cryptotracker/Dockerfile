FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
ADD target/springtest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
