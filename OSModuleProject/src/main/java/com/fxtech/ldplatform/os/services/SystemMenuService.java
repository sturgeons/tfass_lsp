package com.fxtech.ldplatform.os.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.mappers.SystemMenuMapper;
import com.fxtech.ldplatform.os.models.SystemMenu;
import com.fxtech.ldplatform.os.models.SystemMenuItem;
import com.fxtech.ldplatform.os.models.SystemMenuMenuitem;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;
import com.fxtech.ldplatform.os.tree.CheckedNode;
import com.fxtech.ldplatform.os.tree.inters.INode;

import tk.mybatis.mapper.entity.Condition;

/**
 * 菜单管理
 *
 * @author FXStudio.Ajaxfan
 */
@Service("systemMenuService")
public class SystemMenuService  {
    /** 菜单数据DAO */
    private @Autowired SystemMenuMapper systemMenuMapper;
    /** 菜单与菜单项对照关系服务 */
    private @Autowired SystemMenuToMenuItemService systemMenuToMenuItemService;
    /** 菜单项数据DAO */
    private @Autowired SystemMenuItemService systemMenuItemService;

    /**
     * 添加新的菜单
     *
     * @param menu
     *            菜单对象
     * @param itemIds
     *            菜单项Id集合
     * @return 消息
     */
    @Transactional
    public FeedBackMessage addOrUpdate(SystemMenu menu, String[] itemIds) {
        // 删除原有的数据
        del(menu.getSysid());

        // 新增菜单对象
        systemMenuMapper.insert(menu);

        // 新增菜单与菜单项对信号关系信息
        systemMenuToMenuItemService.addOrUpdate(menu.getSysid(), itemIds);

        return new FeedBackMessage(true);
    }

    /**
     * 删除菜单
     *
     * @param sysid
     *            菜单ID
     * @return 消息
     */
    @Transactional
    public FeedBackMessage del(String sysid) {
        // 删除菜单记录
        systemMenuMapper.deleteByPrimaryKey(sysid);

        // 删除菜单和菜单项的关系记录
        systemMenuToMenuItemService.del(sysid);

        return new FeedBackMessage(true);
    }

    /**
     * 生产菜单树(将菜单信息转换为树形结构)
     *
     * @param sysid
     * @return
     */
    public List<INode> extratMenus(String sysid) {
        // 菜单树对象
        List<INode> list = new ArrayList<INode>();

        // 已经选中菜单项
        List<SystemMenuMenuitem> checkeds = systemMenuToMenuItemService.getList(sysid);

        // 遍历系统中所有已维护的菜单项，用它们和之前获得数据作比对
        // 从而判断哪些菜单项应该处于选中状态
        for (SystemMenuItem smi : systemMenuItemService.getAll()) {
            CheckedNode node = new CheckedNode();// 带有Check状态的树节点
            node.setSn(smi.getSysid());// 节点ID
            node.setText(smi.getItemname());// 节点名称
            node.setChecked(isChecked(smi.getSysid(), checkeds));// 节点被选中

            list.add(node);
        }
        return list;
    }

    /**
     * @param cf
     * @return
     */
    public List<SystemMenu> findRecords(ConditionFiled cf) {
        Condition condition = new Condition(SystemMenu.class);
        condition.setOrderByClause("menuname desc");
        
        return systemMenuMapper.selectByExampleAndRowBounds(condition,
                new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
    }

    /**
     * 节点是否被选中
     *
     * @param sysid
     * @param items
     * @return
     */
    private boolean isChecked(String sysid, List<SystemMenuMenuitem> items) {
        for (SystemMenuMenuitem smmi : items) {
            if (sysid.equals(smmi.getItemid())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     */
    public List<SystemMenu> getAll() {
        return systemMenuMapper.selectAll();
    }
}
