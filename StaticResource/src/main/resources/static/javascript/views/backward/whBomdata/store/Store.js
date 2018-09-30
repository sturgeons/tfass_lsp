Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/WHbomdataService/find',
            create: 'v1/WHbomdataService/add',
            update: 'v1/WHbomdataService/update',
            destroy: 'v1/WHbomdataService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});