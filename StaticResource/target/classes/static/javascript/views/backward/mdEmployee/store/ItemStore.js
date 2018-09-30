Ext.define('LDPlatformModule.store.ItemStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.QualityModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/STemlineService/findBindByUser',
            destroy: 'v1/MDemqualityService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});