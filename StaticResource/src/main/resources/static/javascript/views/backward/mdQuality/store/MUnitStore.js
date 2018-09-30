Ext.define('LDPlatformModule.store.MUnitStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.MUnitModel',
    
    autoLoad: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/MDmeasurementunitService/find',//请求
        reader: {
            type: 'json'
        }
    }
});