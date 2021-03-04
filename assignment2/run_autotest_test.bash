#!/bin/bash

echo "(1/4)Clean up Autotest ------------------------"
rm -rf AutoTest/eecs4313a2b
rm -rf AutoTest/eecs4313a2w

echo "(2/4)Copy Test files to Autotest ------------------------"
cp -rf eecs4313a2b/src/eecs4313a2b AutoTest
cp -rf eecs4313a2w/src/eecs4313a2w AutoTest

cd AutoTest
echo "(3/4)Blackbox testing ------------------------"
javac -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar eecs4313a2b/*.java
java -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore eecs4313a2b.EECS4313A2AllBlackBoxTests

echo "(4/4)Whitebox testing ------------------------"
javac -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar eecs4313a2w/*.java
java -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore eecs4313a2w.EECS4313A2AllWhiteBoxTests