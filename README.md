# NOTE 
Modified from : https://github.com/loosebazooka/simple-spring-boot-appengine-app/

Used bitbucket steps/configuration from: https://github.com/GoogleCloudPlatform/continuous-deployment-bitbucket

# Spring-boot Appengine flex app deployed via bitbucket-pipelines
A hello world Spring-boot on appengine flex with bitbucket pipelines 

## Getting Started
- make sure you're using Java 8
- install the Google Cloud SDK https://cloud.google.com/sdk/
- install java appengine components
```
gcloud components install app-engine-java
```
- clone this project
```
git clone https://github.com/mzouitni/spring-boot-appengine-bitbucket-pipelines
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
  
# Deploy via bitbucket pipelines  

## Prerequisites

* You have a Bitbucket account.
* You have a Google App Engine account and have created a project.

## Steps to deploy to your own App Engine project

Note that the Books API Key is a specific requirement of this app,
but is not generally necessary to deploy from Bitbucket Pipelines.
The service account credential is always necessary, 
in order to authenticate the `gcloud` command line tool.

* Enable your repo or fork of this repo for Bitbucket Pipelines.
* Enable the Books API.
* Enable the App Engine Admin API.

Configure the following environment variables for Bitbucket Pipelines:

* `CLOUDSDK_CORE_PROJECT`: Use the id of the Google App Engine project.
* `GOOGLE_API_KEY`: (Private) Create a new public Server API Key in the Google console.
* `GOOGLE_CLIENT_SECRET`: (Private) Create a new Service Account JSON file in the Google console. Copy the contents into this environment variable.

## Licensing

* See [LICENSE](LICENSE)  
