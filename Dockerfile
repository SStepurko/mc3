# define base docker image
FROM openjdk:17
# copy files
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} mc3.jar
# how to run
ENTRYPOINT ["java","-jar","/mc3.jar"]
# port for application
# EXPOSE 10003