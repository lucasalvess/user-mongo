# Imagem base
FROM openjdk:13-jdk-slim

WORKDIR /app

COPY build/libs/example-mongo.jar .

CMD ["-jar", "./example-mongo.jar"]

# Expõe a porta 8080 quando o container é montado.
EXPOSE 8080