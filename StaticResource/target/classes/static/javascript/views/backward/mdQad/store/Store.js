Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDqadService/find',
            create: 'v1/MDqadService/add',
            update: 'v1/MDqadService/update',
            destroy: 'v1/MDqadService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});