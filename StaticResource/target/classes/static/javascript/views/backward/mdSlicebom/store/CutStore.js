Ext.define('LDPlatformModule.store.CutStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.CutModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDslicecutService/find',//请求
        reader: {
            type: 'json'
        }
    }
});