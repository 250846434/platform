package com.lc.platform.mybatis.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.IService;

public class BaseController<Service extends IService<T>,T> {
	@Autowired
	protected Service service;
}
