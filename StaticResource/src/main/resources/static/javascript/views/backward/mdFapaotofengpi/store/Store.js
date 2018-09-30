Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/WHfapaotofengpiService/find',
            update: 'v1/WHfapaotofengpiService/update'
        },
        reader: {
            type: 'json',
            idProperty: 'QADNO'
        }
    }
});