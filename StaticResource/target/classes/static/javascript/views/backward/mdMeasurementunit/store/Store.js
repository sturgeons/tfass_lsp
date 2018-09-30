Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDmeasurementunitService/find',
            create: 'v1/MDmeasurementunitService/add',
            update: 'v1/MDmeasurementunitService/update',
            destroy: 'v1/MDmeasurementunitService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});