Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/RPstorestatusService/query',
            update: 'v1/RPstorestatusService/update'
        },
        reader: {
            type: 'json',
            idProperty: 'QADNO'
        }
    }
});