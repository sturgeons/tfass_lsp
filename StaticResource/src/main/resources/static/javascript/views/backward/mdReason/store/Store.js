Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDreasonService/find',
            create: 'v1/MDreasonService/add',
            update: 'v1/MDreasonService/update',
            destroy: 'v1/MDreasonService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});