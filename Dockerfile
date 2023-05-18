FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD /target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV DB_HOST=containers-us-west-172.railway.app
ENV DB_PORT=7039
ENV DB_NAME=railway
ENV DB_USERNAME=root
ENV DB_PASSWORD=9OA3lEQvX5vaj824ptiF
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
