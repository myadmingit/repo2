package com.local.service.Impl;

import com.local.dao.LogDao;
import com.local.domain.SysLog;
import com.local.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao dao;
    @Override
    public void savelog(SysLog log) {
     dao.savelog(log);
    }

    @Override
    public List<SysLog> findAllLog() {
        return dao.findAllLog();
    }
}
