package org.MyApp;

import org.MyApp.Data.Config;
import org.MyApp.Data.DbStructure;
import org.MyApp.controllers.DatabaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //Start http server
        SpringApplication.run(Application.class, args);

        //ArrayList<DbStructure> DbData = new ArrayList<DbStructure>();

        /*String[] commands = {"'Biden', 'Joe', '1942-11-20', 'Male', 'petty theft', '2000-1-1', '2020-1-1'",
                        "'Trump', 'Donald', '1946-6-14' , 'Male', 'vehicular manslaughter', '1998-3-11' , '1998-4-1'",
                        "'Obama', 'Barack', '1961-8-4' , 'Male', 'Tax evasion', '2000-3-2' , '2004-11-7'"};*/

        //DatabaseController.insertToDB("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", commands);

        //DbData = new ArrayList<DbStructure>(DatabaseController.selectEverything("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000"));

        //DbData.add( DatabaseController.selectById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "5"));

        //DatabaseController.deleteById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "5");

        //DatabaseController.updateById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "9", "SentanceEnd", "2007-04-01");

        /*for (DbStructure i: DbData) {
            System.out.println(i.toString());
        }*/

    }
}
