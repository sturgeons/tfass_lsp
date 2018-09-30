Ext.define('LDPlatformModule.store.AssyEmStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.AssyEmModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/RPreportService/findAssyEM'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});