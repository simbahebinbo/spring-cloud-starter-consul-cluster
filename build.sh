#!/usr/bin/env bash

CurrentDir=$(dirname $0)

find $CurrentDir -name "build" | xargs rm -rf
find $CurrentDir -name "out" | xargs rm -rf
$CurrentDir/gradlew clean  build



