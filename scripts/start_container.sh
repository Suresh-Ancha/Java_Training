#!/bin/bash
set -e

# Pull the Docker image from Docker Hub
docker pull sureshancha/simple-java-flask-app:latest

# Run the Docker image as a container
docker run -d -p 5000:5000 sureshancha/simple-java-flask-app:latest
