Ext.define('LDPlatformModule.store.ChecktypeStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.ChecktypeModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDchecktypeService/find',//请求
        reader: {
            type: 'json'
        }
    }
});