Ext.define('LoginModule.view.Window', {
	extend: 'Ext.window.Window',
    alias: 'widget.loginWindow',
    
    requires: ['LoginModule.view.Form'],
    
    header: {
    	title: '录入员工号登入系统'
    },
    closable: false,
    draggable: false,
    resizable: false,
    width: 400,
    height: 160,
    layout: 'fit',   
    items: {xtype: 'loginform'}
})