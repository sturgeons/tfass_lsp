Ext.define('LDPlatformModule.view.WindowComponent', {
	extend: 'Ext.window.Window',
	alias: 'widget.windowcomponent',
	
	requires: ["LDPlatformModule.view.FormComponent"],
	
	title: '维护无纸化模板',
    iconCls: 'feed-icon',
    resizable: false,
    modal: true,
    width: 800,
    y: 100,
    closeAction: 'hide',
    items: {xtype: 'formcomponent'},
    buttons: [{
        text: '提交',
        action: 'submit'
    }, {
        text: '取消',
        action: 'cancel'
    }]
});