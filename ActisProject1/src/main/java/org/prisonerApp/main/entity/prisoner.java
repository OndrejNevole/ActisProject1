package org.prisonerApp.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class prisoner {
    @jakarta.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int Id;
    private String LastName;
    private String FirstName;
    private LocalDate Birthday;
    private String Gender;
    private String Crime;
    private LocalDate SentanceStart;
    private LocalDate SentanceEnd;

    public prisoner(int id, String lastName, String firstName, LocalDate birthday, String gender, String crime, LocalDate sentanceStart, LocalDate sentanceEnd) {
        Id = id;
        LastName = lastName;
        FirstName = firstName;
        Birthday = birthday;
        Gender = gender;
        Crime = crime;
        SentanceStart = sentanceStart;
        SentanceEnd = sentanceEnd;
    }

    public prisoner(String lastName, String firstName, LocalDate birthday, String gender, String crime, LocalDate sentanceStart, LocalDate sentanceEnd) {
        LastName = lastName;
        FirstName = firstName;
        Birthday = birthday;
        Gender = gender;
        Crime = crime;
        SentanceStart = sentanceStart;
        SentanceEnd = sentanceEnd;
    }

    public prisoner() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCrime() {
        return Crime;
    }

    public void setCrime(String crime) {
        Crime = crime;
    }

    public LocalDate getSentanceStart() {
        return SentanceStart;
    }

    public void setSentanceStart(LocalDate sentanceStart) {
        SentanceStart = sentanceStart;
    }

    public LocalDate getSentanceEnd() {
        return SentanceEnd;
    }

    public void setSentanceEnd(LocalDate sentanceEnd) {
        SentanceEnd = sentanceEnd;
    }

    @Override
    public String toString() {
        return "prisoner{" +
                "Id=" + Id +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Birthday=" + Birthday +
                ", Gender='" + Gender + '\'' +
                ", Crime='" + Crime + '\'' +
                ", SentanceStart=" + SentanceStart +
                ", SentanceEnd=" + SentanceEnd +
                '}';
    }

    public LocalDate parseString(String stringDate) {
        LocalDate date;
        return date = LocalDate.parse(stringDate);
    }
}
