# This is a Spring boot application with Angular frontend (unfinished)
This is a test application \
The application uses a PostgreSQL database and spring boot to create REST API \
There are example requests in: "ActisProject1\ActisProject1\src\main\java\org\prisonerApp\main\example-requests.http"

## Build steps

To run the application, first build it using: 

	mvn compile

 and:

 	mvn package

  This should create a .jar file ("ActisProject1/target/main-0.0.1-SNAPSHOT.jar) \
  To run it use this command:

  	java -jar main-0.0.1-SNAPSHOT.jar

Now the application should run on: "http://localhost:8080/Prisoners"

## Endpoint overwiev:

<ul>
  <li>Select all endpoint(GET): "http://localhost:8080/Prisoners/All"</li>
  <li>Select by id endpoint(GET): "http://localhost:8080/Prisoners/{id}"</li>
  <li>Insert data endpoint(POST): "http://localhost:8080/Prisoners"</li>
  <li>Delete data endpoint(DELETE): "http://localhost:8080/Prisoners/{id}"</li>
  <li>update data endpoint(PUT): "http://localhost:8080/Prisoners/{id}"</li>
</ul>

## User credentials
To communicate with database, the application needs user credentials: 
<ul>
  <li>address of the database</li>
  <li>username</li>
  <li>password</li>
</ul>
To configure these parameters head to the <b>application.properties</b> file ("ActisProject1\ActisProject1\src\main\resources\application.properties")
