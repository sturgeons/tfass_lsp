Ext.define('LDPlatformModule.store.ProgStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.ProgModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDsliceprogService/find',//请求
        reader: {
            type: 'json'
        }
    }
});