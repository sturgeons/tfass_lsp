Ext.define('MainModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/QAdataService/find'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});