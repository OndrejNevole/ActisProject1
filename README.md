# This is a Spring boot application with Angular frontend (unfinished)
This is a test application \
The application uses a PostgreSQL database and spring boot to create REST API 


## Build steps

To start the backend project navigate to: "ActisProject1\ActisProject1" \
Then run the "./Gradlew bootRun" command \
The application should run on: "http://localhost:8080"

## Endpoint overwiev:

<ul>
  <li>Select all endpoint(GET): "http://localhost:8080/TrialDb/SelectAll"</li>
  <li>Select by id endpoint(GET): "http://localhost:8080/TrialDb/SelectById"</li>
  <li>Insert data endpoint(POST): "http://localhost:8080/TrialDb/PostToDb"</li>
  <li>Delete data endpoint(DELETE): "http://localhost:8080/TrialDb/Delete"</li>
  <li>update data endpoint(PUT): "http://localhost:8080/TrialDb/Update"</li>
</ul>

## User credentials
To communicate with database, the application needs user credentials: 
<ul>
  <li>address of the database</li>
  <li>username</li>
  <li>password</li>
</ul>
To configure these parameters head to: "ActisProject1\ActisProject1\src\main\java\org\MyApp\Data\Config.java" 

## Database table
This application communicates with a database table called "prisoners" \
To create this table, run this SQL command:

	CREATE TABLE prisoners  
		ID INT IDENTITY(1,1) PRIMARY KEY, 
		LastName VARCHAR(255), 
		FirstName VARCHAR(255), 
		Birthday DATE, 
		Gender VARCHAR(255), 
		Crime VARCHAR(255), 
		SentanceStart DATE, 
		SentanceEnd DATE 
	)
