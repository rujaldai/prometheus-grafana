FROM eclipse-temurin
RUN mkdir /opt/app
COPY ./build/libs/angular-springboot-0.0.1.jar /opt/app/springboot-app.jar
#COPY ./build/libs/angular-springboot-0.0.1-plain.jar /opt/app/springboot-app-plain.jar
EXPOSE 8080
# cmd ["java", "-jar", "/springboot-app.jar"]
ENTRYPOINT ["java", "-jar", "/opt/app/springboot-app.jar"]