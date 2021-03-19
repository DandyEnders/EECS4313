#!/bin/bash

echo "(1/3)Clean up Autotest ------------------------"
rm -rf AutoTest/eecs4313a3t1

echo "(2/3)Copy Test files to Autotest ------------------------"
cp -rf eecs4313a3t1/src/eecs4313a3t1 AutoTest

cd AutoTest
echo "(3/3)Run Tests ------------------------"
javac -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar eecs4313a3t1/*.java
java -cp .:common-1.9.0.jar:junit-4.13.1.jar:model-1.9.jar:swingui-1.9.jar:hsqldb-1.8.0.10.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore eecs4313a3t1.EECS4313A3AllTests