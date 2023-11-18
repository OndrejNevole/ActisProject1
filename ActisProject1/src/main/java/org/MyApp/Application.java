package org.MyApp;

import org.MyApp.controllers.DatabaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        String[] commands = {"'Biden', 'Joe', '1942-11-20', 'Male', 'petty theft', '2000-1-1', '2020-1-1'",
                        "'Trump', 'Donald', '1946-6-14' , 'Male', 'vehicular manslaughter', '1998-3-11' , '1998-4-1'",
                        "'Obama', 'Barack', '1961-8-4' , 'Male', 'Tax evasion', '2000-3-2' , '2004-11-7'"};

        String sql = "INSERT INTO prisoners (LastName, FirstName, Birthday, Gender, Crime, SentanceStart, SentanceEnd) VALUES (";

        //DatabaseController.insertToDB("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", commands, sql);

        DatabaseController.selectEverything("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "prisoners");
    }
}
