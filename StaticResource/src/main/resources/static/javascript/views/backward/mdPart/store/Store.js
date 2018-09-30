Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDpartService/find',
            create: 'v1/MDpartService/add',
            update: 'v1/MDpartService/update',
            destroy: 'v1/MDpartService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});