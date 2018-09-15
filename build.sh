#!/bin/sh

docker build ./mysql/ -t db
docker run -it -d -p 3306:3306 --name mysql db

docker build ./website/ -t web
docker run -it -d -p 3001:80 --link mysql:db web
