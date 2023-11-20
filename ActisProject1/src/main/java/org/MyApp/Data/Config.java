package org.MyApp.Data;

public class Config {
    //Address of the database
    public String DbAddress = "jdbc:postgresql://localhost:5432/TrialDB";
    //Login username to the database
    public String Username = "postgres";
    //Login password to the database
    public String Password = "000";

    public String getDbAddress() {
        return DbAddress;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
