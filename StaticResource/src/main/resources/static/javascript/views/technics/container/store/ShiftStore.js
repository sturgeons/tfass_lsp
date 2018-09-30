Ext.define('MainModule.store.ShiftStore', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.ShiftModel',
    
    id: 'ShiftStore',
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QAshiftService/find',//请求
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