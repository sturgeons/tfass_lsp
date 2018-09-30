Ext.define('MainModule.store.QadnoStore', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.QadnoModel',
    
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
            store.insert(0, Ext.create('MainModule.model.QadnoModel', {QADNO:''}));
   	 }
    }
});