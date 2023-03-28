FROM amazoncorretto:17-al2-jdk
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/enterprise-integration-workshop3-1.0.0-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]