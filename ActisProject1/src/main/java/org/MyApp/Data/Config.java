package org.MyApp.Data;

public class Config {
    public String DbAddress = "jdbc:postgresql://localhost:5432/TrialDB";
    public String Username = "postgres";
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
