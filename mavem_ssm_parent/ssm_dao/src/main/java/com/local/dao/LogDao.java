package com.local.dao;

import com.local.domain.SysLog;

import java.util.List;

public interface LogDao {
    public void savelog(SysLog log);


   List<SysLog> findAllLog();
}
