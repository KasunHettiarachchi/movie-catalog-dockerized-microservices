FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD /target/movie-info-service-0.0.1-SNAPSHOT.jar movie-info-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movie-info-service-0.0.1-SNAPSHOT.jar"]