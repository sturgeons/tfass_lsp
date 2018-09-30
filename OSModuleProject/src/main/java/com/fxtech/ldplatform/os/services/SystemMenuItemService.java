package com.fxtech.ldplatform.os.services;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.mappers.SystemMenuItemMapper;
import com.fxtech.ldplatform.os.models.SystemMenuItem;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;

/**
 * 系统菜单项
 *
 * @author FXStudio.Ajaxfan
 */
@Service("systemMenuItemService")
public class SystemMenuItemService {
    /** 菜单项Dao */
    private @Autowired SystemMenuItemMapper systemMenuItemMapper;

    /**
     * 通过主键来删除数据
     *
     * @param sysid
     *            系统逐渐
     * @return 消息
     */
    @Transactional
    public FeedBackMessage del(String sysid) {
        // 删除菜单项对象
        systemMenuItemMapper.deleteByPrimaryKey(sysid);

        return new FeedBackMessage(true);
    }

    /**
     * 数据的添加或删除
     *
     * @param menu_item
     * @return
     */
    @Transactional
    public FeedBackMessage addOrUpdate(SystemMenuItem item) {
        // 删除菜单项对象
        del(item.getSysid());

        // 新增菜单项
        systemMenuItemMapper.insert(item);

        return new FeedBackMessage(true);
    }

    /**
     * 查询所有的菜单项
     * 
     * @return
     */
    public List<SystemMenuItem> getAll() {
        return systemMenuItemMapper.selectAll();
    }

    /**
     * 所有的菜单项记录
     * 
     * @param cf
     * @return
     */
    public List<SystemMenuItem> findRecords(ConditionFiled cf) {
        return systemMenuItemMapper.selectByExampleAndRowBounds(null,
                new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
    }

    /**
     * @param itemid
     * @return
     */
    public SystemMenuItem findMenuItem(String itemid) {
        return systemMenuItemMapper.selectByPrimaryKey(itemid);
    }
}
