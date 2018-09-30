Ext.define('MainModule.store.CheckedStore', {
    extend: 'Ext.data.Store',
    model: 'MainModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/QAcheckedService/find'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});