Ext.define('LDPlatformModule.store.FabricStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.FabricModel',
    
    autoLoad: false,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDslicefabricService/findByQadno',//请求
        reader: {
            type: 'json'
        }
    }
});