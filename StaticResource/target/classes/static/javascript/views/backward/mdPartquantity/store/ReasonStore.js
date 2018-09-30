Ext.define('LDPlatformModule.store.ReasonStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.ReasonModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDadjustreasonService/find',//请求
        reader: {
            type: 'json'
        }
    }
});