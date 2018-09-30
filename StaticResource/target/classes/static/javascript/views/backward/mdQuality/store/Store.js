Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDqualityService/find',
            create: 'v1/MDqualityService/add',
            update: 'v1/MDqualityService/update',
            destroy: 'v1/MDqualityService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'ID'
        }
    }
});