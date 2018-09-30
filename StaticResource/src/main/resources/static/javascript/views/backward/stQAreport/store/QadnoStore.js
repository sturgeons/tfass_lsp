Ext.define('LDPlatformModule.store.QadnoStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.QadnoModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QAqadnoService/find',//请求
        reader: {
            type: 'json'
        }
    },
    listeners: {
   	 'load': function(store, records, options) {
            store.insert(0, Ext.create('LDPlatformModule.model.QadnoModel', {QADNO:''}));
   	 }
    }
});