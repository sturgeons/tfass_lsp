package com.fxtech.ldplatform.os.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fxtech.ldplatform.os.models.SystemMenuItem;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;
import com.fxtech.ldplatform.os.services.SystemMenuItemService;
import com.github.pagehelper.PageInfo;

/**
 * 计重设备异常异常
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class SystemMenuItemController {
	private @Autowired SystemMenuItemService systemMenuItemService;

	/**
	 * 菜单项列表
	 *
	 * @param limit
	 *            单页数据量
	 * @param start
	 *            数据页码
	 * @return
	 */
	@RequestMapping(value = "menuItemList")
	public Object menuItemList(ConditionFiled cf) {
		// 数据集合和分页信息
		PageInfo<SystemMenuItem> pageInfo = new PageInfo<SystemMenuItem>(systemMenuItemService.findRecords(cf));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", pageInfo.getTotal());// 记录总数
		map.put("items", pageInfo.getList());// 记录行对象

		return map;
	}

	/**
	 * 删除功能菜单项
	 *
	 * @param sn
	 * @return
	 */
	@RequestMapping(value = "delMenuItem")
	public Object delMenuItem(@RequestParam(value = "sysid", required = true) String sysid) {
		return systemMenuItemService.del(sysid);
	}

	/**
	 * 修改菜单项
	 *
	 * @param sn
	 * @return
	 */
	@RequestMapping(value = "menuItemModify")
	public Object menuItemModify(SystemMenuItem menu_item) {
		return systemMenuItemService.addOrUpdate(menu_item);
	}
}
