Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDsliceqadService/find',
            create: 'v1/MDsliceqadService/add',
            update: 'v1/MDsliceqadService/update',
            destroy: 'v1/MDsliceqadService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});