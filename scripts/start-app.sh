#!/bin/bash

java -Dserver.port=8081 -jar /tmp/.jar > /dev/null 2> /dev/null < /dev/null &
