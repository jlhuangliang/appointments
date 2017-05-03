#!/bin/sh

cd config-server
./gradlew bootrun &
cd -

cd webservice-registry
./gradlew bootrun &
cd -

cd doctor-webservice
./gradlew bootRun &
cd -

cd patient-webservice
./gradlew bootRun &
cd -

cd appointment-webservice
./gradlew bootRun &
cd -

cd api-gateway
./gradlew bootRun &
cd -

