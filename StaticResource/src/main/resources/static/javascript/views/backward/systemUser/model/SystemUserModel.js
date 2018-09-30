/**
 * 树节点模型对象
 */
Ext.define('SystemUserModule.model.SystemUserModel', {
	extend: 'Ext.data.Model',
	fields: [
	    'sysid', 'username', 'password', 'createtime',  'islock', 'depid', 'groupid'
    ]
});