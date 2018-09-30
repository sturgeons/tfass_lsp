Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDsliceprogService/find',
            create: 'v1/MDsliceprogService/add',
            update: 'v1/MDsliceprogService/update',
            destroy: 'v1/MDsliceprogService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});