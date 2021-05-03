#!/bin/bash

set -x

# Running java app
java -server \
     -Dserver.port=8085 \
     -jar /home/product/product-service.jar
