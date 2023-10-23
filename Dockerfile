FROM openjdk:8-jdk-alpine

RUN mkdir -p /data/app

COPY target/empty_backend-1.0-SNAPSHOT.jar /data/app/app.jar

WORKDIR /data/app

EXPOSE 8086

CMD ["java","-jar","app.jar"]
