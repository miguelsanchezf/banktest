FROM openjdk:11-jdk-oracle
COPY "./target/movimiento-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]