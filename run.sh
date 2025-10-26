#!/bin/bash
export JAVA_HOME=/home/marcelo-agil/java/jdk-25
export PATH=$JAVA_HOME/bin:$PATH
export MAVEN_OPTS="--enable-native-access=ALL-UNNAMED"

mvn -q compile exec:java -Dexec.mainClass="Main"