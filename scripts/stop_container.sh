#!/bin/bash
set -e

# Stop the running container (if any)
containerId=$(docker ps | awk 'NR==2 {print $1}')
docker rm -f $containerId

