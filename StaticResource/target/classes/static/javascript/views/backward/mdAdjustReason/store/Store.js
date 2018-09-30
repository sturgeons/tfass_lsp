Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDadjustreasonService/find',
            create: 'v1/MDadjustreasonService/add',
            update: 'v1/MDadjustreasonService/update',
            destroy: 'v1/MDadjustreasonService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});