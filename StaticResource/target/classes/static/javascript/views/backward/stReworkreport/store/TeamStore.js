Ext.define('LDPlatformModule.store.TeamStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.TeamModel',
    
    autoLoad: true,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDteamnoService/find'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});