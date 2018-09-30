package com.fxtech.ldplatform.api.abstracts.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Excel 工具的抽象接口定义
 * 
 * @author Ajaxfan
 */
public abstract class BaseExcel {
	public abstract void export(String meta, String data, OutputStream out) throws IOException;

	public abstract void export(String meta, List datas, OutputStream out) throws IOException;

	public abstract void export(List datas, OutputStream out) throws IOException;
}
