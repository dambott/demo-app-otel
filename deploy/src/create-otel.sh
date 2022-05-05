#! /bin/zsh

source values.sh

FILE=${1:-.}

### 
##  Creates the OTEL config file for k8s
### 

echo "apiVersion: v1"
echo "kind: ConfigMap"
echo "metadata:"
echo "# Open Telemetry configuration property files"
echo "   name: " otel-config
echo "   namespace: " $K8S_NAMESPACE
echo "data:"

for f in $FILE/*.* ; do
	echo "  $(basename $f): |"
	envsubst < $f 
	echo "\n"
done
