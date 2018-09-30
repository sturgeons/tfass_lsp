Ext.define('MainModule.store.OPStore', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.OPModel',
    
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
	            store.insert(0, Ext.create('MainModule.model.OPModel', {OP:''}));
	   	 }
    }
});