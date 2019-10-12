FROM openjdk:11
WORKDIR usr/src
COPY ./target/config-server-0.0.1-SNAPSHOT.jar /usr/src/config-server-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/usr/src/config-server-0.0.1-SNAPSHOT.jar"]
