Ext.define('LDPlatformModule.store.TeamnoStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.TeamnoModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/RPreportService/findTeamno'
        },
        reader: {
            type: 'json',
            idProperty: 'SYSID'
        }
    }
});