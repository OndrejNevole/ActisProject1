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
    public static void insertToDB(String address, String login, String password, String[] commands) {
        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);

            db.setAutoCommit(false);
            Statement stmt = db.createStatement();

            for (String i: commands) {
                i = "INSERT INTO prisoners (LastName, FirstName, Birthday, Gender, Crime, SentanceStart, SentanceEnd) VALUES (" + i + " );";
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
    public static ArrayList<DbStructure> selectEverything(String address, String login, String password) {

        ArrayList<DbStructure> DbData = null;

        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners");

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
                System.out.println(x.toString());

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
    //delete data from database by Id
    public static DbStructure selectById(String address, String login, String password, String ID) {

        DbStructure x = null;
        try {
            //connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners WHERE id = " + ID);
            
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
                System.out.println(x.toString());
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
    //delete data from database by Id
    public static void deleteById(String address, String login, String password, String ID) {
        try {
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            stmt.executeUpdate("DELETE FROM prisoners WHERE id = " + ID);

            db.commit();
            stmt.close();
            db.close();

            System.out.println("DELETEd successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    //update database data by Id
    public static void updateById(String address, String login, String password, String ID, String updateColumn, String updateValue) {
        DbStructure x =null;
        try {
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            stmt.executeUpdate("UPDATE prisoners SET " + updateColumn + " = '" + updateValue + "' WHERE ID = " + ID);

            //SELECT updated row
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners WHERE id = " + ID);

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
                System.out.println(x.toString());
            }

            db.commit();
            stmt.close();
            db.close();

            System.out.println("UPDATEd successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
