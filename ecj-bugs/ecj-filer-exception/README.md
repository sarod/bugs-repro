# How to reproduce


##  Using Maven
Run the following commands

Compile the project
```sh
mvn clean compile
```

Modify MyDataClass.java 
```sh
touch src/main/java/bugs/repro/MyDataClass.java
```

Compile the project again WITHOUT clean
```sh
mvn -X compile
```

The compilation ends with "BUILD SUCCESS" but it's wrong.

However it did not generate the class files and it issued the warning
```
1. WARNING in /home/sarod/dev/git/bugs-repro/ecj-bugs/ecj-filer-exception/src/main/java/bugs/repro/MyDataClass.java (at line 6)
	public abstract class MyDataClass {
	                      ^^^^^^^^^^^
Could not write generated class bugs.repro.AutoValue_MyDataClass: javax.annotation.processing.FilerException: Source file already exists : bugs.repro.AutoValue_MyDataClass
```

## Using intellij

1. Open the project using intellij community edition.
2. Build the whole project using "Build">"Rebuild Project".
3. Open the file src/main/java/bugs/repro/MyDataClass.java
4. Re-compile this file only using "Build">"Recompile '...MyDataClass.java'".

The "Messages" view displays the same warning.