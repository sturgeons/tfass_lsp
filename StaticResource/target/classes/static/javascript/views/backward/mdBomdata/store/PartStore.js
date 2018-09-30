Ext.define('LDPlatformModule.store.PartStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.PartModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDpartService/find',//请求
        reader: {
            type: 'json'
        }
    }
});