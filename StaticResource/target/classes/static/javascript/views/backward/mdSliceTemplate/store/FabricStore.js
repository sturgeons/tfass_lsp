Ext.define('LDPlatformModule.store.FabricStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.FabricModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDslicefabricService/find',//请求
        reader: {
            type: 'json'
        }
    }
});