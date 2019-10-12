FROM openjdk:11
WORKDIR usr/src
COPY ./target/testdemo-0.0.1-SNAPSHOT.jar /usr/src/testdemo-0.0.1-SNAPSHOT.jar
ENV MYSQL_DATABASE=movieDb
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDb?useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
EXPOSE 8070
ENTRYPOINT ["java","-jar","/usr/src/testdemo-0.0.1-SNAPSHOT.jar"]