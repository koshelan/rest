FROM openjdk:11-jdk-alpine
EXPOSE 8080
ADD target/demo-0.0.1-SNAPSHOT.jar signin.jar
ENTRYPOINT ["java", "-jar", "/signin.jar"]