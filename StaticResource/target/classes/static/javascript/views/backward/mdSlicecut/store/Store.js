Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDslicecutService/find',
            create: 'v1/MDslicecutService/add',
            update: 'v1/MDslicecutService/update',
            destroy: 'v1/MDslicecutService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});