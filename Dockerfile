FROM openjdk:11
ADD target/codercollective-0.0.1-SNAPSHOT.jar codercollective-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "codercollective-0.0.1-SNAPSHOT.jar"]

