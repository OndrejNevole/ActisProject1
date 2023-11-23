# This is a Spring boot application with Angular frontend (unfinished)
This is a test application \
The application uses a PostgreSQL database and spring boot to create REST API 

## Build steps

To run the application, first build it using: 

	mvn compile

 and:

 	mvn package

  This should create a .jar file ("ActisProject1/target/main-0.0.1-SNAPSHOT.jar) \
  To run it use this command:

  	java -jar main-0.0.1-SNAPSHOT.jar

Now the application should run on: "http://localhost:8080/Prisoners"

## API overwiev

### Endpoints:

<ul>
  <li>Select all endpoint(GET): "http://localhost:8080/Prisoners/All"</li>
  <li>Select by id endpoint(GET): "http://localhost:8080/Prisoners/{id}"</li>
  <li>Insert data endpoint(POST): "http://localhost:8080/Prisoners"</li>
  <li>Delete data endpoint(DELETE): "http://localhost:8080/Prisoners/{id}"</li>
  <li>update data endpoint(PUT): "http://localhost:8080/Prisoners/{id}"</li>
</ul>

### cURL commands to test the API

To get every prisoner:

 	curl http://localhost:8080/Prisoners/All

To get single prisoner:

	curl http://localhost:8080/Prisoners/{id of prisoner}  

 To upload a prisoner:

 	curl -X POST http://localhost:8080/Prisoners -H "Content-Type: application/json" -d '{"lastName":"Bush","firstName":"George","birthday":"1946-07-06","gender":"Male","crime":"breaking and entering","sentanceStart":"1990-10-01","sentanceEnd":"1991-01-01"}'

 To delete a prisoner:

 	curl -X DELETE http://localhost:8080/Prisoners/{id of prisoner}

  To update a prisoner:

  	curl -X PUT http://localhost:8080/Prisoners/{id of prisoner} -H "Content-Type: application/json" -d '{"lastName":"Bill","firstName":"Clinton"}'

   There are also example requests in: "ActisProject1\ActisProject1\src\main\java\org\prisonerApp\main\example-requests.http"

## User credentials
To communicate with database, the application needs user credentials: 
<ul>
  <li>address of the database</li>
  <li>username</li>
  <li>password</li>
</ul>
To configure these parameters head to the <b>application.properties</b> file ("ActisProject1\ActisProject1\src\main\resources\application.properties")
