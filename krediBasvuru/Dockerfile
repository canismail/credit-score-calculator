FROM openjdk:12
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} krediBasvuru-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","krediBasvuru-0.0.1-SNAPSHOT.jar"]
