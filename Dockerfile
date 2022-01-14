FROM openjdk:17

RUN mkdir -p /usr/src/myapp
COPY . /usr/src/myapp

WORKDIR /usr/src/myapp/src/main/java/com/interview/Authorization_and_survey/

EXPOSE 8080
RUN javac Application.java
CMD ["java", "Application"]