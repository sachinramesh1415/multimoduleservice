FROM openjdk:11
WORKDIR usr/src
COPY ./target/eureka-server-0.0.1-SNAPSHOT.jar /usr/src/eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/src/eureka-server-0.0.1-SNAPSHOT.jar"]