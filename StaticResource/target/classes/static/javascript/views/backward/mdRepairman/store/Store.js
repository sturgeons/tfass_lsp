Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDrepairmanService/find',
            create: 'v1/MDrepairmanService/add',
            update: 'v1/MDrepairmanService/update',
            destroy: 'v1/MDrepairmanService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});