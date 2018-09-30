Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDsliceboxService/find',
            create: 'v1/MDsliceboxService/add',
            update: 'v1/MDsliceboxService/update',
            destroy: 'v1/MDsliceboxService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});