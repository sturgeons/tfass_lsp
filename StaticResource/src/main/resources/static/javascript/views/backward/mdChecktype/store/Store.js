Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDchecktypeService/find',
            create: 'v1/MDchecktypeService/add',
            update: 'v1/MDchecktypeService/update',
            destroy: 'v1/MDchecktypeService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});