package org.MyApp.controllers;

import org.MyApp.Data.DbStructure;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    //Try to connect to a database
    public static void connectToDB(String address /*Database address*/, String login /*User login*/, String password /*User password*/) {

        try {
            Connection db = DriverManager.getConnection(address, login, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    //Insert data to database
    public static void insertToDB(String address /*Database address*/, String login /*User login*/, String password /*User password*/, String[] commands /*Data to add*/) {
        try {
            //Connect to database
            Connection db = DriverManager.getConnection(address, login, password);

            db.setAutoCommit(false);
            Statement stmt = db.createStatement();
            //Execute all commands
            for (String i: commands) {
                i = "INSERT INTO prisoners (LastName, FirstName, Birthday, Gender, Crime, SentanceStart, SentanceEnd) VALUES (" + i + " );";
                stmt.executeUpdate(i);
            }

            //End connection
            stmt.close();
            db.commit();
            db.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    //Select from database
    public static ArrayList<DbStructure> selectEverything(String address /*Database address*/, String login /*User login*/, String password /*User password*/) {
        //List to store data
        ArrayList<DbStructure> DbData = null;

        try {
            //Connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            //Execute statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners");

            DbData = new ArrayList<DbStructure>();

            while (rs.next()) {
                //Parse data from database
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
                //Add data to list
                DbData.add(x);
            }
            //End connection
            stmt.close();
            db.commit();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        //Return data
        return DbData;
    }
    //Delete data from database by Id
    public static DbStructure selectById(String address /*Database address*/, String login /*User login*/, String password /*User password*/, String ID /*Id of desired row*/) {

        DbStructure x = null;
        try {
            //Connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            //Execute statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners WHERE id = " + ID);
            
            while (rs.next()) {
                //Parse data
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
            //End connection
            stmt.close();
            db.commit();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        //Return data
        return x;
    }
    //Delete data from database by Id
    public static void deleteById(String address /*Database address*/, String login /*User login*/, String password /*User password*/, String ID /*Id of row to be deleted*/) {
        try {
            //Connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            //Execute statement
            stmt.executeUpdate("DELETE FROM prisoners WHERE id = " + ID);
            //End connection
            db.commit();
            stmt.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    //Update database data by Id
    public static void updateById(String address /*Database address*/, String login /*User login*/, String password /*User password*/, String ID /*Id of row to be updated*/, String updateColumn /*Name of updated column*/, String updateValue /*Correct value*/) {
        DbStructure x =null;
        try {
            //Connect to database
            Connection db = DriverManager.getConnection(address, login, password);
            db.setAutoCommit(false);

            Statement stmt = db.createStatement();
            //Execute statement
            stmt.executeUpdate("UPDATE prisoners SET " + updateColumn + " = '" + updateValue + "' WHERE ID = " + ID);

            //SELECT updated row
            ResultSet rs = stmt.executeQuery("SELECT * FROM prisoners WHERE id = " + ID);

            while (rs.next()) {
                //Parse updated data
                int Id = rs.getInt("ID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Date birthday = rs.getDate("Birthday");
                String gender = rs.getString("Gender");
                String crime = rs.getString("Crime");
                Date sentanceStart = rs.getDate("SentanceStart");
                Date sentanceEnd = rs.getDate("SentanceEnd");

                x = new DbStructure(Id, lastName, firstName, birthday, gender, crime, sentanceStart, sentanceEnd);
                //Log updated data
                System.out.println(x.toString());
            }
            //End connection
            db.commit();
            stmt.close();
            db.close();
            //Log success
            System.out.println("UPDATEd successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
