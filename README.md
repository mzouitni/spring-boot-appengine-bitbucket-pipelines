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
- If the plugin is unable to discover the location of the Cloud SDK automatically, specify it in the configuration:
    
    ``` 
    model {
      appengine {
        tools {
          cloudSdkHome = "/path/to/cloud/sdk"
        }
      }
    }
    ```
- You are now ready to run commands
  - Stage : `./gradlew appengineStage`
  - Deploy : `./gradlew appengineDeploy`
  
### Maven
- If the plugin is unable to discover the location of the Cloud SDK automatically, specify it in the configuration:
```
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>appengine-maven-plugin</artifactId>
    <version>0.1.0-beta</version>
    <configuration>
        <cloudSdkPath>/path/to/cloud/sdk</cloudSdkPath>
    </configuration>
</plugin>
```
- You are now ready to run commands
  - Stage : `mvn appengine:stage`
  - Deploy : `mvn appengine:deploy`
