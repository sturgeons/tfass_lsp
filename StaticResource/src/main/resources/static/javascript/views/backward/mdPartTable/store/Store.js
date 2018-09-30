Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDparttableService/find',
            create: 'v1/MDparttableService/add',
            update: 'v1/MDparttableService/update',
            destroy: 'v1/MDparttableService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});