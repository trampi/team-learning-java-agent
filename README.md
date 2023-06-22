# using java agents

Small team learning to show how to use agents in a java application.

Usage:

```shell
# compile agent
cd agent
./gradlew clean jar

# compile application
cd ../spring-boot-bytebuddy
./gradlew clean bootJar

# run application
java -javaagent:../agent/build/libs/spring-boot-bytebuddy-0.0.1-SNAPSHOT.jar -jar build/libs/spring-boot-bytebuddy-0.0.1-SNAPSHOT.jar

# in a second terminal test application and observe agent output in first terminal
curl localhost:8080/
```
