Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDslicefabricService/find',
            create: 'v1/MDslicefabricService/add',
            update: 'v1/MDslicefabricService/update',
            destroy: 'v1/MDslicefabricService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});