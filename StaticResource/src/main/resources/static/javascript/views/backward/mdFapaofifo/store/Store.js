Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/WHfapaofifoService/find',
            update: 'v1/WHfapaofifoService/update'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});