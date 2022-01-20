
FROM openjdk:17-alpine
COPY ./target/Survay-1.0-SNAPSHOT.jar /home/app/target/Survay-1.0-SNAPSHOT.jar
EXPOSE 8080
ENV TZ Europe/Moscow
ENTRYPOINT ["java","-jar","/home/app/target/Survay-1.0-SNAPSHOT.jar"]do