package com.fxtech.ldplatform.os.services;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.mappers.SystemGroupMapper;
import com.fxtech.ldplatform.os.models.SystemGroup;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;

/**
 * 用户组相关的服务
 *
 * @author FXStudio.Ajaxfan
 */
@Service("systemGroupService")
public class SystemGroupService {
    /** 用户组Dao */
    private @Autowired SystemGroupMapper systemGroupMapper;
    /** 维护用户组菜单相关的服务 */
    private @Autowired SystemGroupToMenuService systemGroupMenuService;

    /**
     * 新增用户组
     * 
     * @param group
     * @param menuIds
     * @return
     */
    @Transactional
    public FeedBackMessage addOrUpdate(SystemGroup group, String[] menuIds) {
        // 删除已存在的数据
        del(group.getSysid());

        // 新增用户组对象
        systemGroupMapper.insert(group);

        // 维护用户组、菜单关系
        systemGroupMenuService.addOrUpdate(group.getSysid(), menuIds);

        return new FeedBackMessage(true);
    }

    /**
     * 删除用户组
     * 
     * @param sysid
     * @return
     */
    @Transactional
    public FeedBackMessage del(String sysid) {
        // 删除用户组信息
        systemGroupMapper.deleteByPrimaryKey(sysid);

        // 删除用户组和菜单的关系记录
        systemGroupMenuService.del(sysid);

        return new FeedBackMessage(true);
    }

    /**
     * 查询全部的用户组信息
     * 
     * @return
     */
    public List<SystemGroup> getAll() {
        return systemGroupMapper.selectAll();
    }

    /**
     * @param cf
     * @return
     */
    public List<SystemGroup> findRecords(ConditionFiled cf) {
        return systemGroupMapper.selectByExampleAndRowBounds(null,
                new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
    }
}
