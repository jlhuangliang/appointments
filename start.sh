#!/bin/sh

cd config-server
./gradlew bootrun

cd ../webservice-registry
./gradlew bootrun
