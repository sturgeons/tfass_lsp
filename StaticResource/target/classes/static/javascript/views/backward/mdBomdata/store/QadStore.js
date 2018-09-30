Ext.define('LDPlatformModule.store.QadStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.QadModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDqadService/find',//请求
        reader: {
            type: 'json'
        }
    }
});