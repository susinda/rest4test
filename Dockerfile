#FROM is the base image for which we will run our application
FROM openjdk:17
# Copy files and directories from the application
COPY target/rest4test*.jar /opt/
#Tell Docker what command to start
CMD java -jar /opt/rest4test*.jar
# Tell Docker we are going to use this port
EXPOSE 8080