FROM openjdk:11
WORKDIR usr/src
COPY ./target/movie-zuul-0.0.1-SNAPSHOT.jar /usr/src/movie-zuul-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/movie-zuul-0.0.1-SNAPSHOT.jar"]
