Ext.define('SystemUserModule.view.SystemUserTabPanel', {
	extend: 'Ext.tab.Panel',
	alias: 'widget.systemusertabpanel',
	
	items: [
	    {// 用户所在组的维护功功能
	    	title: '所属用户组',
	    	layout: 'fit',
	    	items: Ext.create('Ext.ux.form.ItemSelector', {
                id: 'itemselector-field',
                imagePath: 'javascript/extjs/ux/css/images/',
                store: Ext.create('Ext.data.Store', {
                	fields: ["groupname", "sysid", "remark"],
                	autoLoad: false,
                	autoDestroy: true,
                    autoSync: false,
                    root: { expanded: true },
                    proxy: {
                        type : 'ajax',
                        actionMethods: { read: 'POST' },
                        url : 'services/userGroupArray',//请求
                        reader: {
                            type: 'json',
                            root: 'items',
                            idProperty: 'sysid'
                        }
                    }
                }),
                displayField: 'groupname',
                valueField: 'sysid',
                allowBlank: true,
                msgTarget: 'side',
                fromTitle: '可分配用户组',
                toTitle: '已分配用户组'
            })
	    }
    ]
});