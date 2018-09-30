Ext.define('MainModule.store.LineStore', {
	extend: 'Ext.data.Store',
    model: 'MainModule.model.LineModel',
    
    autoLoad: false,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QAlineService/find',//请求
        reader: {
            type: 'json'
        }
    },
     listeners: {
    	 'load': function(store, records, options) {
             store.insert(0, Ext.create('MainModule.model.LineModel', {LINE:''}));
    	 }
     }
});