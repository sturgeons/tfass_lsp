Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDpartquantityService/find',
            create: 'v1/MDpartquantityService/add',
            update: 'v1/MDpartquantityService/update',
            destroy: 'v1/MDpartquantityService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});