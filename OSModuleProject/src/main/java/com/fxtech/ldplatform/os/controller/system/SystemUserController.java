package com.fxtech.ldplatform.os.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.models.SystemUser;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;
import com.fxtech.ldplatform.os.services.SystemUserService;
import com.github.pagehelper.PageInfo;

/**
 * 维护系统用户服务接口
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class SystemUserController {
	private @Autowired SystemUserService systemUserService;

	/**
	 * 菜单列表
	 *
	 * @param limit
	 *            开始索引
	 * @param start
	 *            结束索引
	 * @return
	 */
	@RequestMapping(value = "systemUserList")
	public Object systemUserList(ConditionFiled cf) {
		PageInfo<SystemUser> pageInfo = new PageInfo<SystemUser>(systemUserService.findRecords(cf));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", pageInfo.getTotal());// 记录总数
		map.put("items", pageInfo.getList());// 记录行对象

		return map;
	}

	/**
	 * 用户组列表
	 *
	 * @param limit
	 *            开始索引
	 * @param start
	 *            结束索引
	 * @return
	 */
	@RequestMapping(value = "delSystemUser")
	public Object delSystemUser(@RequestParam(value = "sysid", required = true) String sysid) {
		return systemUserService.del(sysid);
	}

	/**
	 * 维护系统用户
	 *
	 * @param sn
	 * @return
	 */
	@RequestMapping(value = "systemUserModify")
	public FeedBackMessage systemUserModify(SystemUser vo) {
		return systemUserService.addOrUpdate(vo);
	}

	/**
	 * 用户组列表
	 *
	 * @param limit
	 *            开始索引
	 * @param start
	 *            结束索引
	 * @return
	 */
	@RequestMapping(value = "userGroupArray", method={RequestMethod.GET, RequestMethod.POST})
	public Object userGroupArray(@RequestParam(value = "userId", required = false, defaultValue = "") String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", systemUserService.getUserGroups(userId));// 记录行对象
		
		return map;
	}
}
