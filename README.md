# This is a Spring boot apllication with Angular frontend (TODO)

## Build steps

To start the backend project navigate to: "ActisProject1\ActisProject1"\
Then run the "./Gradlew bootRun" command\
The application should run on: "http://localhost:8080"\
The application uses PostgreSQL databse\

## Endpoint overwiev:

<ul>
  <li>Select all GET endpoint: "http://localhost:8080/TrialDb/SelectAll"</li>
  <li>Select by id GET endpoint: "http://localhost:8080/TrialDb/SelectById"</li>
  <li>POST endpoint: "http://localhost:8080/TrialDb/PostToDb"</li>
  <li>DELETE endpoint: "http://localhost:8080/TrialDb/Delete"</li>
  <li>PUT endpoint: "http://localhost:8080/TrialDb/Update"</li>
</ul>

## ser credentials
To communicate with database, the application needs user credentials:\
<ul>
  <li>address of the database</li>
  <li>username</li>
  <li>password</li>
</ul>
To configure these parameters head to: "ActisProject1\ActisProject1\src\main\java\org\MyApp\Data\Config.java"\
  
