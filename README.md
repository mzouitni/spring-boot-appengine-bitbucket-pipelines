# NOTE 
Modified from : https://github.com/spring-guides/gs-spring-boot

# spring-boot-appengine-app
A very simple spring-boot on appengine project

## Getting Started
- make sure you're using Java 8
- install the Google Cloud SDK https://cloud.google.com/sdk/
- install java appengine components
```
gcloud components install app-engine-java
```
- clone this project
```
git clone https://github.com/loosebazooka/simple-spring-boot-appengine-app
```

### Gradle
- Add a **`gradle.properties`** file in the base directory with the contents so the build.gradle can resolve the value correctly
    
    ``` 
    cloudSdkHome=/path/to/cloud/sdk
    ```
- You are now ready to run commands
  - Stage : `./gradlew gcpAppStage`
  - Deploy : `./gradlew gcpAppDeploy`
  
### Maven
- If the plugin is unable to discover the location of the Cloud SDK automatically, specify it in the configuration:
```
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>gcp-app-maven-plugin</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <configuration>
        <cloudSdkPath>/path/to/cloud/sdk</cloudSdkPath>
    </configuration>
</plugin>
```
- You are now ready to run commands
  - Stage : `mvn gcp-app:stage`
  - Deploy : `mvn gcp-app:deploy`
