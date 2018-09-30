Ext.define('LDPlatformModule.store.QualityStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.QualityModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/STemlineService/findUnBindByUser'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});