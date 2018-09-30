Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDslicebomService/find',
            create: 'v1/MDslicebomService/add',
            update: 'v1/MDslicebomService/update',
            destroy: 'v1/MDslicebomService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});