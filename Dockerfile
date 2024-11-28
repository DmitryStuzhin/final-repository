FROM gradle:8.4-focal as build

WORKDIR /workspace

COPY src ./src
COPY build.gradle ./build.gradle
COPY settings.gradle ./settings.gradle

RUN gradle clean build

FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /app

COPY --from=build /build/libs/final-projectt-0.0.1-SNAPSHOT.jar ./application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]