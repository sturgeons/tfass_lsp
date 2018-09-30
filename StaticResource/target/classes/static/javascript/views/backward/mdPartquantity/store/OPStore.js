Ext.define('LDPlatformModule.store.OPStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.OPModel',
    
    autoLoad: false,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/STopService/findAll',//请求
        reader: {
            type: 'json'
        }
    }
});