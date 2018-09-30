Ext.define('LDPlatformModule.view.Viewport', {
	    extend: 'Ext.container.Viewport',
	
	    requires: [
	               'LDPlatformModule.view.GridComponent',
	               'LDPlatformModule.view.AssyEmGrid'
	    ],
	
	    layout: 'border',
	    items: [{
	        xtype: 'gridcomponent',
	        region: 'center'
	    }, {
	    	xtype: 'tabpanel',
	    	region: 'south',
	    	tabPosition: 'top',
	        height: 240,
	    	items: [
	    	        {xtype:'assyemgrid'}
	    	]
	    }]
});
