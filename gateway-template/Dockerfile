FROM openjdk:17
# sed -i 's/{JAR_NAME}/$MAVEN_PROJECT_NAME-$MAVEN_PROJECT_VERSION/' Dockerfile
COPY ./target/{JAR_NAME}.jar /data/app/
CMD ["java", "-jar", "/data/app/{JAR_NAME}.jar"]
EXPOSE 8000