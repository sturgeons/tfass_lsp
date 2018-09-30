Ext.define('LDPlatformModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
               'LDPlatformModule.view.GridComponent',
               'LDPlatformModule.view.PartGrid'
    ],

    layout: 'border',
    defaults: { split: true },
    items: [{
    	xtype: 'gridcomponent',
    	region: 'north',
        height: 260
    }, {
    	xtype: 'partgrid',
    	region: 'center'
    }]
});
