package org.MyApp.controllers;

import java.sql.*;

public class DatabaseController {
    //Try to connect to a database
    public static void connectToDB(String address, String login, String password) {

        try {
            Connection db = DriverManager.getConnection(address, login, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    //insert data to database
    public static void insertToDB(String address, String login, String password, String[] commands, String template ) {

        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);

            db.setAutoCommit(false);
            Statement stmt = db.createStatement();

            for (String i: commands) {
                i = template + i + " );";
                stmt.executeUpdate(i);
            }


            stmt.close();
            db.commit();
            db.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    //select from database
    public static void selectEverything(String address, String login, String password, String tableName) {
        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            Object rs = stmt.executeQuery("SELECT * FROM " + tableName);




            stmt.close();
            db.commit();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
