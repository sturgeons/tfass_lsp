package com.fxtech.ldplatform.api.entities;

/**
 * 报表头接口
 * 
 * @author Ajaxfan
 */
public class Header {
	private String colunmName;
	private String fieldName;
	private Integer width;

	public String getColunmName() {
		return colunmName;
	}

	public void setColunmName(String colunmName) {
		this.colunmName = colunmName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Header() {
	}

	public Header(String colunmName, String fieldName, Integer width) {
		this.colunmName = colunmName;
		this.fieldName = fieldName;
		this.width = width;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}
