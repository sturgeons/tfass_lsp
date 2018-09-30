Ext.define('LDPlatformModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: ['LDPlatformModule.view.GridComponent', 'LDPlatformModule.view.ItemGrid'],

    layout: 'border',
    items: [{
    	region: 'center',
        xtype: 'gridcomponent'
    }, {
    	title: '绑定生产线',
    	region: 'south',
    	height: 300,
        xtype: 'itemgrid'
    }]
});
