#!/bin/bash

java -Dserver.port=8081 -jar /tmp/regioncheck-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &
