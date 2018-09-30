Ext.define('LDPlatformModule.store.LineStore', {
	extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.LineModel',
    
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
             store.insert(0, Ext.create('LDPlatformModule.model.LineModel', {LINE:''}));
    	 }
     }
});