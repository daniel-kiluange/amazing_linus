FROM gradle:7.4.2-jdk17 AS TEMP_BUILD_IMAGE
ENV BUILD_HOME=/usr/src/app
COPY . $BUILD_HOME
WORKDIR $BUILD_HOME
RUN gradle clean assemble --info

FROM openjdk:17-alpine
WORKDIR /usr/app

COPY --from=TEMP_BUILD_IMAGE /usr/src/app/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/app/app.jar"]
