package com.hujesse.onlineSchool.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMeteObjectHandler implements MetaObjectHandler {
    // 使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
       this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        /**
         * this clause has bugs derived from reference doc
         * `this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); `
         */
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
