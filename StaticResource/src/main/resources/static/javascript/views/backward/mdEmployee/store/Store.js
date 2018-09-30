Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDemployeeService/find',
            create: 'v1/MDemployeeService/add',
            update: 'v1/MDemployeeService/update',
            destroy: 'v1/MDemployeeService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});