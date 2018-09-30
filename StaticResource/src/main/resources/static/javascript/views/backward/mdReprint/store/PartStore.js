Ext.define('LDPlatformModule.store.PartStore', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.PartModel',

    autoLoad: true,
    data: [],
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'users'
        }
    }
});