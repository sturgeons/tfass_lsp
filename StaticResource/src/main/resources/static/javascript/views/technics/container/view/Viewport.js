Ext.define('MainModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'MainModule.view.GridPanel',
        'MainModule.view.UserPanel'
    ],

    layout: 'border',
    items: [{
    	title: '用户信息',
        xtype: 'userpanel',
        region: 'west'
     }, {
    	 region: 'center',
    	 layout: 'border',
    	 items : [{
	    	title: '待录入工艺文件',
	        xtype: 'gridpanel',
	        region: 'center'
	     }]
     }]
});
