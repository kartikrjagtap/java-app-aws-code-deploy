#!/bin/bash

ps -ef | grep .jar | grep -v grep | awk '{print $2}' | xargs kill
