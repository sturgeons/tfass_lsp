package com.fxtech.ldplatform.os.services;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxtech.ldplatform.api.messages.FeedBackMessage;
import com.fxtech.ldplatform.os.mappers.SystemUserMapper;
import com.fxtech.ldplatform.os.models.SystemGroup;
import com.fxtech.ldplatform.os.models.SystemUser;
import com.fxtech.ldplatform.os.protocal.ConditionFiled;
import com.fxtech.utils.StringHelper;
import com.fxtech.utils.UUIDGenerator;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 系统用户
 *
 * @author FXStudio.Ajaxfan
 */
@Service("systemUserService")
public class SystemUserService {
    /** 用户信息Dao */
    private @Autowired SystemUserMapper systemUserMapper;
    /** 用户组信息服务 */
    private @Autowired SystemGroupService systemGroupService;

    /**
     * @param user
     * @return
     */
    public FeedBackMessage addOrUpdate(SystemUser user) {
    	if (StringHelper.isNullOrEmpty(user.getSysid())) {
			user.setSysid(UUIDGenerator.random());
			user.setPassword(user.getPassword());
			systemUserMapper.insertSelective(user);
		} else {
			// 判断用户是否修改了密码
			Condition condition = new Condition(SystemUser.class);
			Criteria criteria = condition.createCriteria();
			criteria.andEqualTo("sysid", user.getSysid());
			criteria.andEqualTo("password", user.getPassword());

			// 只有在密码被修改的情况下，才能执行密码加密操作
			if (systemUserMapper.selectByExample(condition).size() == 0) {
				user.setPassword(user.getPassword());
			}
			systemUserMapper.updateByPrimaryKey(user);
		}
		return new FeedBackMessage(true);
    }

    /**
     * 待选用户组
     *
     * @param userID
     * @return
     */
    public List<SystemGroup> getUserGroups(String userId) {
        SystemUser user = findUser(userId);

        // 获得全部的用户组信息
        List<SystemGroup> list = systemGroupService.getAll();

        // 判断用户组是否被选中
        if (user != null) {
            for (SystemGroup group : list) {
                if (group.getSysid().equals(user.getGroupid())) {
                    group.setRemark("true");
                }
            }
        }
        return list;
    }

    /**
     * 删除用户信息
     *
     * @param sysid
     *            用户Id
     * @return 消息
     */
    @Transactional
    public FeedBackMessage del(String sysid) {
        return new FeedBackMessage(systemUserMapper.deleteByPrimaryKey(sysid) > 0);
    }

    /**
     * 查询用户登录信息
     * 
     * @param fields
     * @return
     */
    public List<SystemUser> findRecords(ConditionFiled cf) {
        Condition condition = new Condition(SystemUser.class);
        condition.setOrderByClause("createtime");
        Criteria criteria = condition.createCriteria();

        // 按组搜索用户
        if (!StringHelper.isNullOrEmpty(cf.getSysid())) {
            criteria.andEqualTo("groupid", cf.getSysid());
            return systemUserMapper.selectByExampleAndRowBounds(condition,
                    new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
        }
        // 查找全部的用户
        else if (StringHelper.isNullOrEmpty(cf.getUsername()) && StringHelper.isNullOrEmpty((cf.getPassword()))) {
            criteria.andNotEqualTo("visible", "1");// 超级管理员账户不可见
            return systemUserMapper.selectByExampleAndRowBounds(condition,
                    new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
        }
        // 查找特定的用户信息
        criteria.andEqualTo("username", cf.getUsername());
        criteria.andEqualTo("password", cf.getPassword());

        return systemUserMapper.selectByExample(condition);
    }

    /**
     * @param sysid
     * @return
     */
    public SystemUser findUser(String sysid) {
        return systemUserMapper.selectByPrimaryKey(sysid);
    }
}
