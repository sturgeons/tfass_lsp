package com.fxtech.ldplatform.core.advices;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;

/**
 * 异常信息拦截
 * 
 * @author Ajaxfan
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	private static final String ERROR_MSG_FORMAT = "url: %s, exception: %s";

	private Logger log = Logger.getLogger(GlobalControllerExceptionHandler.class);

	/**
	 * 统一的异常处理函数
	 * 
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	FeedBackMessage defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ByteArrayOutputStream out = null;
		PrintStream stream = null;

		try {
			e.printStackTrace(stream = new PrintStream(out = new ByteArrayOutputStream()));
			log.error(String.format(ERROR_MSG_FORMAT, req.getRequestURL(), e.getMessage()));
			log.error(new String(out.toByteArray()));
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} finally {
					stream = null;
				}
			}
			if (out != null) {
				try {
					out.close();
				} finally {
					out = null;
				}
			}
		}
		return new FeedBackMessage(false, "系统错误，详细信息请查看运行日志.");
	}
}
