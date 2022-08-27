# define base docker image
FROM openjdk:8-jdk-alpine
LABEL maintainer="javaguides.net"
ADD target/springboot-docker-demo-0.0.1-SNAPSHOT.jar springboot-docker-demoo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demoo.jar"]