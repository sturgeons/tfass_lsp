Ext.define('LDPlatformModule.store.AssyStateStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.AssyStateModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/RPreportService/findAssyState'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});