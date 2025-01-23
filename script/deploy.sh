#!/bin/bash
# Determine the environment and copy the corresponding appspec file
if [ -f /opt/deployment/appspec-dev.yml ]; then
    cp /opt/deployment/appspec-dev.yml /opt/deployment/appspec.yml
elif [ -f /opt/deployment/appspec-tst.yml ]; then
    cp /opt/deployment/appspec-tst.yml /opt/deployment/appspec.yml
elif [ -f /opt/deployment/appspec-prd.yml ]; then
    cp /opt/deployment/appspec-prd.yml /opt/deployment/appspec.yml
else
    echo "No matching appspec file found."
    exit 1
fi
