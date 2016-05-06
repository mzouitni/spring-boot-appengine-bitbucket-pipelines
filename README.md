# NOTE 
Modified from : https://github.com/spring-guides/gs-spring-boot

# spring-boot-appengine-app
A very simple spring-boot on appengine project

## Getting Started
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
  
