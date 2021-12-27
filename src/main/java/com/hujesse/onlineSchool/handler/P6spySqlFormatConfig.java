package com.hujesse.onlineSchool.handler;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hujesse.onlineSchool.utils.DateUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.util.Date;

public class P6spySqlFormatConfig implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtils.parseDateToStr(new Date())
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + "\n" + sql.replaceAll("[\\s]+", " ") + ";" : "";
    }
}

