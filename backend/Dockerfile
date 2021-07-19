FROM java:8
EXPOSE 8080
ADD /target/backend-0.0.1-SNAPSHOT.war backend.war
ENTRYPOINT ["java","-jar","backend.war"]