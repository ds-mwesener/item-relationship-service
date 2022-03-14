#!/bin/bash

set -euxo pipefail

REGISTRY=$1
IMAGE=$2
TAG=$3

export DOCKER_BUILDKIT=1

docker build --build-arg BUILD_TARGET=$IMAGE --build-arg IRS_EDC_PKG_USERNAME=$IRS_EDC_PKG_USERNAME --build-arg IRS_EDC_PKG_PASSWORD=$IRS_EDC_PKG_PASSWORD --target $IMAGE -t $REGISTRY/$IMAGE:$TAG .
if ! docker push $REGISTRY/$IMAGE:$TAG; then
  az acr login -n $REGISTRY
  docker push $REGISTRY/$IMAGE:$TAG
fi
