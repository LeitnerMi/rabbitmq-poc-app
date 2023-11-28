#!/usr/bin/env bash
cd ../../../
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/rabbitmq-poc-app-jvm .
docker tag quarkus/rabbitmq-poc-app-jvm:latest ghcr.io/leitnermi/rabbitmq-poc-app-jvm:topics
docker push ghcr.io/leitnermi/rabbitmq-poc-app-jvm:topics
