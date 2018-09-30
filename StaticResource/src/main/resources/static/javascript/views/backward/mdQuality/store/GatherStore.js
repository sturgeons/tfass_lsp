Ext.define('LDPlatformModule.store.GatherStore', {
	extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.GatherModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QAgatherService/find',//请求
        reader: {
            type: 'json'
        }
    },
     listeners: {
    	 'load': function(store, records, options) {
             store.insert(0, Ext.create('LDPlatformModule.model.GatherModel', {LINE:''}));
    	 }
     }
});