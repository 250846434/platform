package com.lc.platform.mybatis.handler;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FieldFillHandler implements MetaObjectHandler {
	@Autowired
	HttpSession session;
	
	@Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("create_date",new Date(), metaObject);//版本号3.0.6以及之前的版本
        this.setFieldValByName("create_user",session.getAttribute("user"), metaObject);//版本号3.0.6以及之前的版本
        this.updateFill(metaObject);
//        this.setInsertFieldValByName("operator", "Jerry", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    	log.info("start update fill ....");
    	this.setFieldValByName("update_date",new Date(), metaObject);//版本号3.0.6以及之前的版本
        this.setFieldValByName("update_user",session.getAttribute("user"), metaObject);//版本号3.0.6以及之前的版本
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }
}
