Ext.define('LDPlatformModule.store.Store', {
    extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.Model',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        api: {
            read: 'v1/MDinstructionService/find',
            update: 'v1/MDinstructionService/update',
            destroy: 'v1/MDinstructionService/del'
        },
        reader: {
            type: 'json',
            idProperty: 'QADNO '
        }
    }
});