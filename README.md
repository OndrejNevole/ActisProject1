# This is a Spring boot apllication with Angular frontend (TODO)

#Build steps
To start the backend project navigate to: "ActisProject1\ActisProject1"
Then run the "./Gradlew bootRun" command
The application should run on: "http://localhost:8080"
The application uses PostgreSQL databse

#Endpoint overwiev:
  Select all GET endpoint: "http://localhost:8080/TrialDb/SelectAll"
  Select by id GET endpoint: "http://localhost:8080/TrialDb/SelectById"
  POST endpoint: "http://localhost:8080/TrialDb/PostToDb"
  DELETE endpoint: "http://localhost:8080/TrialDb/Delete"
  PUT endpoint: "http://localhost:8080/TrialDb/Update"

#User credentials
To communicate with database, the application needs user credentials:
  address of the database
  username 
  password
To configure these parameters head to: "ActisProject1\ActisProject1\src\main\java\org\MyApp\Data\Config.java"
  
