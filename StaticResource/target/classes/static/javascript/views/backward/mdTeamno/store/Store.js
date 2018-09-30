Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDteamnoService/find',
            create: 'v1/MDteamnoService/add',
            update: 'v1/MDteamnoService/update',
            destroy: 'v1/MDteamnoService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});