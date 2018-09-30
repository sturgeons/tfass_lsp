package com.fxtech.ldplatform.os.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.mappers.SystemGroupMenuMapper;
import com.fxtech.ldplatform.os.models.SystemGroupMenu;
import com.fxtech.ldplatform.os.models.SystemMenu;
import com.fxtech.ldplatform.os.models.SystemMenuItem;
import com.fxtech.ldplatform.os.models.SystemMenuMenuitem;
import com.fxtech.ldplatform.os.tree.CheckedNode;
import com.fxtech.ldplatform.os.tree.NormalNode;
import com.fxtech.ldplatform.os.tree.inters.INode;

import tk.mybatis.mapper.entity.Condition;

/**
 * 维护部门菜单对照关系
 *
 * @author FXStudio.Ajaxfan
 */
@Service("groupToMenuService")
public class SystemGroupToMenuService {
    /** 部门菜单Dao */
    private @Autowired SystemGroupMenuMapper deptMenuMapper;

    private @Autowired SystemMenuService systemMenuService;

    private @Autowired SystemMenuToMenuItemService systemMenuToMenuItemService;

    private @Autowired SystemMenuItemService systemMenuItemService;

    /**
     * 变更部门菜单关系
     *
     * @param sysid
     * @param menuIds
     * @return
     */
    @Transactional
    public FeedBackMessage addOrUpdate(String sysid, String[] menuIds) {
        // 删除以前维护的关系记录
        del(sysid);

        // 维护用户组和菜单对象的对照关系
        for (String menuId : menuIds) {
            SystemGroupMenu deptMenu = new SystemGroupMenu();
            deptMenu.setGroupid(sysid);
            deptMenu.setMenuid(menuId);

            deptMenuMapper.insert(deptMenu);
        }
        return new FeedBackMessage(true);
    }

    /**
     * 删除指定用户组的对照关系
     * 
     * @param sysid
     * @return
     */
    @Transactional
    public FeedBackMessage del(String sysid) {
        Condition condition = new Condition(SystemGroupMenu.class);
        condition.createCriteria().andEqualTo("groupid", sysid);
        deptMenuMapper.deleteByExample(condition);

        return new FeedBackMessage(true);
    }

    /**
     * 系统菜单
     *
     * @param groupId
     * @return
     */
    public List<INode> getSystemMenu(String groupId) {
        List<INode> tree = new ArrayList<INode>();
        List<SystemGroupMenu> groupMenus = getGroupMenus(groupId);

        // 菜单
        for (SystemMenu sm : systemMenuService.getAll()) {
            CheckedNode menuNode = new CheckedNode();
            menuNode.setSn(sm.getSysid());
            menuNode.setText(sm.getMenuname());
            menuNode.setChecked(isChecked(sm.getSysid(), groupMenus));

            // 菜单项
            for (SystemMenuMenuitem smmi : getSystemMenuItems(sm.getSysid())) {
                SystemMenuItem smi = systemMenuItemService.findMenuItem(smmi.getItemid());

                NormalNode node = new NormalNode();
                node.setSn(smi.getSysid());
                node.setText(smi.getItemname());

                menuNode.addChild(node);
            }
            tree.add(menuNode);
        }

        return tree;
    }

    /**
     * @param groupId
     * @return
     */
    private List<SystemGroupMenu> getGroupMenus(String groupId) {
        Condition condition = new Condition(SystemGroupMenu.class);
        condition.createCriteria().andEqualTo("groupid", groupId);

        return deptMenuMapper.selectByExample(condition);
    }

    /**
     * @param sysid
     * @param list
     * @return
     */
    private boolean isChecked(String sysid, List<SystemGroupMenu> list) {
        for (SystemGroupMenu sgm : list) {
            if (sysid.equals(sgm.getMenuid())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param menuid
     * @return
     */
    private List<SystemMenuMenuitem> getSystemMenuItems(String menuid) {
        return systemMenuToMenuItemService.getList(menuid);
    }
}
