package com.uabc.database.example.examplejpa.services.impl;

import com.uabc.database.example.examplejpa.components.LogConverter;
import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.repository.LogRepository;
import com.uabc.database.example.examplejpa.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service("logServiceImpl")
public class LogServiceImpl implements LogService {

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Autowired
    @Qualifier("logConverter")
    private LogConverter logConverter;

    @Override
    public LogModel addLog(LogModel logModel) throws Exception {
        Log temp = logConverter.convertLogModel2Log(logModel);
        Log log = logRepository.save(temp);
        return logConverter.convertLog2LogModel(log);
    }

    public List<LogModel> listAllLogs() throws ParseException {
        List<Log> logs = logRepository.findAll();
        List<LogModel> logsModel = new ArrayList();
        for(Log log : logs)
            logsModel.add(logConverter.convertLog2LogModel(log));
        return logsModel;
    }

    @Override
    public Log findLogById(int id) {
        return logRepository.findById(id);
    }

    public LogModel findLogByIdModel(int id) {
        return logConverter.convertLog2LogModel(findLogById(id));
    }

    @Override
    public void removeLog(int id) {
        Log log = findLogById(id);
        if(log != null)
            logRepository.delete(findLogById(id));
    }
}
