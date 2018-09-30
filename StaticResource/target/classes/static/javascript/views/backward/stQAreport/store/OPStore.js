Ext.define('LDPlatformModule.store.OPStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.OPModel',
    
    autoLoad: false,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QAopService/find',//请求
        reader: {
            type: 'json'
        }
    },
    listeners: {
	   	 'load': function(store, records, options) {
	            store.insert(0, Ext.create('LDPlatformModule.model.OPModel', {OP:''}));
	   	 }
    }
});