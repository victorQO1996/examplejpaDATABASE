package com.uabc.database.example.examplejpa.services;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service("logService")
public interface LogService {
    public abstract LogModel addLog(LogModel logModel) throws Exception;

    public abstract List<LogModel> listAllLogs() throws ParseException;

    public abstract Log findLogById(int id);

    public abstract void removeLog(int id);

    public abstract LogModel findLogByIdModel(int id);
}
