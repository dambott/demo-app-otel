#! /bin/bash

source ../../deploy/src/values.sh
cp ../../inventory/target/amd64/inventory inventory
envsubst <  ../../deploy/src/data/inventory.conf > inventory.conf
#envsubst < ../../deploy/src/data/wf-config.yaml > wf-config.yaml
envsubst < ../../deploy/src/otel/$1-blue.properties > $1.properties
