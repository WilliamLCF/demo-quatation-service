# Dockerfile Example
FROM openjdk:11
ADD target/quatation-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Xmx64m", "-Xms64m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
