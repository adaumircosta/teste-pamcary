FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/ws-pamcary-client-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ws-pamcary-client-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/ws-pamcary-client-0.0.1-SNAPSHOT.jar"]
