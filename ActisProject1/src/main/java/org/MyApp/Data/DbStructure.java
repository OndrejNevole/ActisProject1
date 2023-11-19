package org.MyApp.Data;

import java.sql.Date;

public class DbStructure {
    public int Id;
    public String lastName;
    public String firstName;
    public Date birthday;
    public String gender;
    public String crime;
    public  Date sentanceStart;
    public Date sentanceEnd;

    public DbStructure(int id, String lastName, String firstName, Date birthday, String gender, String crime, Date sentanceStart, Date sentanceEnd) {
        Id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.crime = crime;
        this.sentanceStart = sentanceStart;
        this.sentanceEnd = sentanceEnd;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public Date getSentanceStart() {
        return sentanceStart;
    }

    public void setSentanceStart(Date sentanceStart) {
        this.sentanceStart = sentanceStart;
    }

    public Date getSentanceEnd() {
        return sentanceEnd;
    }

    public void setSentanceEnd(Date sentanceEnd) {
        this.sentanceEnd = sentanceEnd;
    }

    public String toString() {
        return "'" + Id + "', '" + lastName + "', '" + firstName + "', '" + birthday.toString() + "', '" + gender + "', '" + crime + "', '" + sentanceStart.toString() + "', '" + sentanceEnd.toString() + "'";
    }
}
