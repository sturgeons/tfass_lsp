Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDstateService/find',
            create: 'v1/MDstateService/add',
            update: 'v1/MDstateService/update',
            destroy: 'v1/MDstateService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});