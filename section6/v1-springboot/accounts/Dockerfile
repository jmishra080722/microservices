#Start with a base image containing Java Runtime
FROM openjdk:21-jdk
#Information around who maintain image
MAINTAINER jmishra080722

#Add the application jar to the the image
COPY  target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the command
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

