package com.fxtech.ldplatform.os.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.os.mappers.SystemGroupMenuMapper;
import com.fxtech.ldplatform.os.mappers.SystemMenuItemMapper;
import com.fxtech.ldplatform.os.mappers.SystemMenuMapper;
import com.fxtech.ldplatform.os.mappers.SystemMenuMenuitemMapper;
import com.fxtech.ldplatform.os.models.SystemGroupMenu;
import com.fxtech.ldplatform.os.models.SystemMenu;
import com.fxtech.ldplatform.os.models.SystemMenuItem;
import com.fxtech.ldplatform.os.models.SystemMenuMenuitem;
import com.fxtech.ldplatform.os.tree.NormalNode;
import com.fxtech.ldplatform.os.tree.inters.INode;

import tk.mybatis.mapper.entity.Example;

/**
 * 系统功能树
 *
 * @author FXStudio.Ajaxfan
 */
@Service("systemMenuTreeService")
public class SystemMenuTreeService {
	private @Autowired SystemGroupMenuMapper systemGroupMenuMapper;
	private @Autowired SystemMenuMapper systemMenuMapper;
	private @Autowired SystemMenuMenuitemMapper systemMenuMenuitemMapper;
	private @Autowired SystemMenuItemMapper systemMenuItemMapper;

	/**
	 * 生成系统功能树结构
	 *
	 * @param depid
	 *            用户组ID
	 * @return
	 */
	public List<INode> getSystemMenu(String depid) {
		List<INode> list = new ArrayList<INode>();

		// 通过管理表，获得用户可访问的所有菜单
		for (SystemGroupMenu dm : getDeptMenus(depid)) {
			SystemMenu sm = systemMenuMapper.selectByPrimaryKey(dm.getMenuid());// 菜单对象
			NormalNode menuNode = new NormalNode();// 生成节点对象
			menuNode.setText(sm.getMenuname());// 设置节点名称

			// 生成菜单项
			for (SystemMenuMenuitem smmi : getSystemMenuItems(sm.getSysid())) {
				SystemMenuItem smi = systemMenuItemMapper.selectByPrimaryKey(smmi.getItemid());
				NormalNode node = new NormalNode();
				node.setSn(smi.getSysid());
				node.setText(smi.getItemname());
				node.setUrl(smi.getItemlink());

				menuNode.addChild(node);
			}
			list.add(menuNode);
		}
		return list;
	}

	/**
	 * 部门 <-> 系统功能菜单对应关系
	 *
	 * @param depid
	 * @return
	 */
	private List<SystemGroupMenu> getDeptMenus(String groupid) {
		Example condition = new Example(SystemGroupMenu.class);
		condition.createCriteria().andEqualTo("groupid", groupid);

		return systemGroupMenuMapper.selectByExample(condition);
	}

	/**
	 * 菜单，菜单项对应关系
	 *
	 * @param depid
	 * @return
	 */
	private List<SystemMenuMenuitem> getSystemMenuItems(String menuid) {
		Example condition = new Example(SystemMenuMenuitem.class);
		condition.createCriteria().andEqualTo("menuid", menuid);

		return systemMenuMenuitemMapper.selectByExample(condition);
	}
}
