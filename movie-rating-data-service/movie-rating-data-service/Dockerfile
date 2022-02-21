FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD /target/movie-rating-data-service-0.0.1-SNAPSHOT.jar movie-rating-data-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movie-rating-data-service-0.0.1-SNAPSHOT.jar"]