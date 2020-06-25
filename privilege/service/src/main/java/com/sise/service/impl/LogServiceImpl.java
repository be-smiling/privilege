package com.sise.service.impl;

import com.sise.dao.LogDao;
import com.sise.domain.SysLog;
import com.sise.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;
    @Override
    public void save(SysLog log) {
        logDao.save(log);
    }
}
