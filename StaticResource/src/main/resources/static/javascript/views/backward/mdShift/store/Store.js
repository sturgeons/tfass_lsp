Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDshiftService/find',
            create: 'v1/MDshiftService/add',
            update: 'v1/MDshiftService/update',
            destroy: 'v1/MDshiftService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});