Ext.define('LDPlatformModule.store.LineStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.LineModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/STlineService/findAll',//请求
        reader: {
            type: 'json'
        }
    }
});