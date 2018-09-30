Ext.define('LDPlatformModule.store.FileTypeStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.FileTypeModel',
    
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