# Dockerfile Example
FROM openjdk:11
ADD target/quatation-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Xmx1024m", "-Xms128m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
