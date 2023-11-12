#!/usr/bin/env bash
cd /home/ubuntu/server
sudo java -jar -Dserver.port=8080 \
    *.jar > /dev/null 2> /dev/null < /dev/null &
