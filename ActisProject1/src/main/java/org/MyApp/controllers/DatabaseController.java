package org.MyApp.controllers;

import org.MyApp.Data.DbStructure;

import java.sql.*;
import java.util.ArrayList;

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
    public static ArrayList<DbStructure> selectEverything(String address, String login, String password, String tableName) {

        ArrayList<DbStructure> DbData = null;

        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);

            DbData = new ArrayList<DbStructure>();

            while (rs.next()) {
                int Id = rs.getInt("ID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Date birthday = rs.getDate("Birthday");
                String gender = rs.getString("Gender");
                String crime = rs.getString("Crime");
                Date sentanceStart = rs.getDate("SentanceStart");
                Date sentanceEnd = rs.getDate("SentanceEnd");

                DbStructure x = new DbStructure(Id, lastName, firstName, birthday, gender, crime, sentanceStart, sentanceEnd);

                DbData.add(x);
            }

            stmt.close();
            db.commit();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return DbData;
    }

    public static DbStructure selectById(String address, String login, String password, String tableName, String ID) {

        DbStructure x = null;
        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + ID);
            
            while (rs.next()) {
                int Id = rs.getInt("ID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Date birthday = rs.getDate("Birthday");
                String gender = rs.getString("Gender");
                String crime = rs.getString("Crime");
                Date sentanceStart = rs.getDate("SentanceStart");
                Date sentanceEnd = rs.getDate("SentanceEnd");

                x = new DbStructure(Id, lastName, firstName, birthday, gender, crime, sentanceStart, sentanceEnd);
            }

            stmt.close();
            db.commit();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return x;
    }
}
