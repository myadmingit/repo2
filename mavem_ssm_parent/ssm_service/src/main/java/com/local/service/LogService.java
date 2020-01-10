package com.local.service;

import com.local.domain.SysLog;

import java.util.List;

public interface LogService {
    void savelog(SysLog log);

    List<SysLog> findAllLog();
}
