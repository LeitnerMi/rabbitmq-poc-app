#!/usr/bin/env bash

./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/rabbitmq-poc-app-jvm .
docker tag quarkus/rabbitmq-poc-app-jvm:latest ghcr.io/leitnermi/rabbitmq-poc-app-jvm:consumer-producer
docker push ghcr.io/leitnermi/rabbitmq-poc-app-jvm:consumer-producer
