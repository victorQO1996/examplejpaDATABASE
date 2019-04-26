package com.uabc.database.example.examplejpa.model;

import lombok.Data;

import java.util.Date;

@Data
public class LogModel {
    private int id;
    private String date;
    private String details;
    private String username;
    private String url;

    public LogModel() {

    }

    @Override
    public String toString() {
        return "LogModer{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", details='" + details + '\'' +
                ", username='" + username + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
