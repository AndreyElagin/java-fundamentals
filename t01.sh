#!/bin/bash
mkdir -p intro-module/build
javac -d intro-module/build -cp intro-module/src/main/java intro-module/src/main/java/javase01/t01/main/Main.java
java -cp intro-module/build javase01.t01.main.Main