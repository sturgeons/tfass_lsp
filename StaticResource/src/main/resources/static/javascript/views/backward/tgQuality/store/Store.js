Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDdatabaseService/find',
            create: 'v1/MDdatabaseService/add',
            update: 'v1/MDdatabaseService/update',
            destroy: 'v1/MDdatabaseService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});