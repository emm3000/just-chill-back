FROM gradle:8.5-jdk17 AS builder
WORKDIR /app

COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY src src

RUN chmod +x gradlew

RUN ./gradlew bootJar --no-daemon

FROM gcr.io/distroless/java17-debian11 AS runtime
WORKDIR /app

COPY --from=builder /app/build/libs/app.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]