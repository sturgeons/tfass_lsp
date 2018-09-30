Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDslicetemplateService/find',
            create: 'v1/MDslicetemplateService/add',
            update: 'v1/MDslicetemplateService/update',
            destroy: 'v1/MDslicetemplateService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});