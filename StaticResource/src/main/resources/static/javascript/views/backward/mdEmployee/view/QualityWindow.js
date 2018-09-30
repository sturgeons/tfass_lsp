Ext.define('LDPlatformModule.view.QualityWindow', {
	extend: 'Ext.window.Window',
	alias: 'widget.qualitywindow',
	
	title: '绑定生产线',
    iconCls: 'feed-icon',
    resizable: false,
    modal: true,
    width: 560,
    y: 100,
    closeAction: 'hide',
    items: Ext.create('LDPlatformModule.view.QualityGrid', {id: 'qualitygrid',height: 300}),
    buttons: [{
        text: '提交',
        action: 'commitQuality'
    }, {
        text: '取消',
        action: 'cancelQuality'
    }]
});