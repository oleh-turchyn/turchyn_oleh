package com.turchyn.usermanagement.model;

import java.io.Serializable;

public class Client implements Serializable {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String patrName;
    protected String passport;
    protected String telNumber;

    public Client(){}
    public Client(int id){
        this.id = id;
    }
    public Client(int id,String firstName, String lastName, String patrName, String passport, String telNumber) {
        this(firstName,lastName,patrName,passport,telNumber);
        this.id=id;
    }

    public Client(String firstName, String lastName, String patrName, String passport, String telNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patrName = patrName;
        this.passport = passport;
        this.telNumber = telNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatrName() {
        return patrName;
    }

    public void setPatrName(String patrName) {
        this.patrName = patrName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patrName='" + patrName + '\'' +
                ", passport='" + passport + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
