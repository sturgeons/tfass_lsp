package com.fxtech.ldplatform.api.messages;

public class CallbackMessage {
	/** 操作是否成功 */
	private boolean success;
	/** 失败信息 */
	private String message;

	private String extra;

	public CallbackMessage(boolean success) {
		super();
		this.success = success;
	}

	public CallbackMessage(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public CallbackMessage(boolean success, String message, String extra) {
		this.success = success;
		this.message = message;
		this.extra = extra;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public String getExtra() {
		return extra;
	}
}
