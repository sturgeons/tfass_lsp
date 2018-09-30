Ext.define('MainModule.view.WindowComponent', {
	extend: 'Ext.window.Window',
	alias: 'widget.windowcomponent',
	
	requires: ["MainModule.view.FormComponent"],
	
	title: '录入工艺数据',
    iconCls: 'feed-icon',
    resizable: false,
    modal: true,
    width: 360,
    height: 600,
    y: 100,
    closeAction: 'hide',
    items: {
    	xtype: 'formcomponent'
    },
    buttons: [{
    	id: 'submitBtn',
        text: '提交',
        action: 'submit'
    }, {
        text: '取消',
        action: 'cancel'
    }]
});