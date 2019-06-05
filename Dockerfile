FROM openjdk:8-jre
EXPOSE 8888
ADD /target/Curriculer-1.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]