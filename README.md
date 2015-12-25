# MongoDB-REST-WebApp-Simple-Example

A sample Java web app project which uses MongoDB.

## Goal

To create a basis for a JSON REST API-providing web app development using MongoDB 
and authorization.

## Current development state

REST API with documentation. MongoDB persistence for model objects. DB interface.

No authorization.

## Instructions

You can test the already deployed test web app's API 
or build and deploy the web app on your server. 

### Test the REST API

API documentation is available [here](app/README.md).

API test hostname is [dev.oleksiykovtun.com](http://dev.oleksiykovtun.com)

### Build and deploy the web app

Requirements: Java, MongoDB.

#### Manual deployment

1. Build the app by Gradle: navigate to project root folder and execute `gradlew app:build`

2. Deploy the built app `app/build/libs/mongorest.war` manually to Tomcat.

#### Running the web app locally

To run the app locally by Gradle: navigate to project root folder and execute `gradlew app:tomcatRunWar`

The running app base URL will be `http://localhost:8080/mongorest/`

To stop the app, execute `gradlew app:tomcatStop`
