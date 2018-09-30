Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/ZPstorestatusService/query',
            update: 'v1/ZPstorestatusService/update'
        },
        reader: {
            type: 'json',
            idProperty: 'QADNO'
        }
    }
});