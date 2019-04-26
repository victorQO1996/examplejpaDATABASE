package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("logConverter")
public class LogConverter {
    public Log convertLogModel2Log(LogModel logModel) throws Exception {
        Log log = new Log();
        String[] dates = logModel.getDate().split("T");
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dates[0] + " " + dates[1]);
        log.setDate(date);
        log.setDetails(logModel.getDetails());
        log.setId(logModel.getId());
        log.setUrl(logModel.getUrl());
        log.setUsername(logModel.getUsername());
        return log;
    }

    public LogModel convertLog2LogModel(Log log){
        LogModel logModel = new LogModel();
        logModel.setDate(log.getDate().toString());
        logModel.setDetails(log.getDetails());
        logModel.setId(log.getId());
        logModel.setUrl(log.getUrl());
        logModel.setUsername(log.getUsername());
        return logModel;
    }
}
