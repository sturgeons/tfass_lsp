package com.fxtech.ldplatform.os.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.models.SystemUser;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;
import com.fxtech.ldplatform.os.services.SystemUserService;

/**
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class SystemLoginController {
	/** 用户服务接口类 */
	private @Autowired SystemUserService systemUserService;

	/**
	 * @return 系统登录
	 */
	@RequestMapping("systemLogin")
	public Object systemLogin(HttpServletRequest request, ConditionFiled cf) {
		List<SystemUser> users = systemUserService.findRecords(cf);

		if (users.size() == 0) {// 如果用户信息不存在，则提示用户错误原因
			return new FeedBackMessage(false, "用户名或密码不正确");
		}
		// 用户信息存在Session中
		request.getSession().setAttribute("freeWayUser", users.get(0));

		return new FeedBackMessage(true);
	}
}
