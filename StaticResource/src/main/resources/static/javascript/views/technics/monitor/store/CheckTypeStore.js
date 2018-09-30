Ext.define('MainModule.store.CheckTypeStore', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.CheckTypeModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDchecktypeService/find',//请求
        reader: {
            type: 'json'
        }
    },
    listeners: {
   	 'load': function(store, records, options) {
            store.insert(0, Ext.create('MainModule.model.CheckTypeModel', {TYPE_NAME:''}));
   	 }
    }
});