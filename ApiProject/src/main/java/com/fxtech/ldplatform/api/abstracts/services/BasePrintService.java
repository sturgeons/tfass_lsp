package com.fxtech.ldplatform.api.abstracts.services;

import java.util.Map;

import com.fxtech.ldplatform.api.inters.services.IPrintService;

/**
 * 打印服务的抽象接口定义
 * 
 * @author Ajaxfan
 */
public class BasePrintService implements IPrintService {

	@Override
	public Object print(Map<String, ?> params) throws Exception {
		throw new UnsupportedOperationException("Un supported operation. the method is not implemented.");
	}
}
