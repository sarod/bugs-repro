#!/bin/sh


M2_REPO=~/.m2/repository/

java -jar $M2_REPO/org/eclipse/jdt/ecj/3.17.0/ecj-3.17.0.jar -noExit -preserveAllLocals -g:"lines,vars,source" -source 1.8 -target 1.8 -encoding UTF-8 -warn:none -cp $M2_REPO/com/google/auto/value/auto-value/1.6.5/auto-value-1.6.5.jar:$M2_REPO/com/google/auto/value/auto-value-annotations/1.6.5/auto-value-annotations-1.6.5.jar -d target/classes -s target/generated-sources/annotations src/main/java/bugs/repro/MyDataClass.java