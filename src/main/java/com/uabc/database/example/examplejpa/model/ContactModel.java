package com.uabc.database.example.examplejpa.model;

import lombok.Data;

@Data
public class ContactModel {
    private int id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String city;

    public ContactModel(){

    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
