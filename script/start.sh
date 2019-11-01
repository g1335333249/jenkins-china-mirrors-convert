#!/usr/bin/env bash
PROJECT_NAME=jenkins-china-mirrors-convert
PROJECT_VERSION=1.0.0-SNAPSHOT
BASE_DIR=$(dirname "$PWD")
cd $BASE_DIR
mvn clean package
mvn docker:build
docker stop $PROJECT_NAME
docker rm $PROJECT_NAME
docker run -p 11302:11302 --name=$PROJECT_NAME -it -d --restart=always $PROJECT_NAME:$PROJECT_VERSION
docker images|grep none|awk '{print $3}'|xargs docker rmi