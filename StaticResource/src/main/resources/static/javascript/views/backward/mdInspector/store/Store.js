Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDinspectorService/find',
            create: 'v1/MDinspectorService/add',
            update: 'v1/MDinspectorService/update',
            destroy: 'v1/MDinspectorService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});