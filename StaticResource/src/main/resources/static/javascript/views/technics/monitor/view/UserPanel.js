Ext.define('MainModule.view.UserPanel' ,{
    extend: 'Ext.form.Panel',
    alias: 'widget.userpanel',
    
    title: '用户信息',
    collapsible: true,
    collapsed: true,
    split: true,
	layout: 'fit',
    width: 320,
    autoScroll: true,
    items: [{
    	contentEl: document.getElementById("userInfo")
    }],
    bbar: ['->',{
        text: '退出系统',
        action: 'exitSystem',
        bodyStyle: 'font-size: 15pt;',
        iconCls: 'exitSystem'
    }]
});