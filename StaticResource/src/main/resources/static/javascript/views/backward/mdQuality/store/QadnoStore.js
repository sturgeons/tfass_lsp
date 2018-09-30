Ext.define('LDPlatformModule.store.QadnoStore', {
	extend: 'Ext.data.Store',
    model: 'LDPlatformModule.model.QadnoModel',
    
    autoLoad: false,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'v1/QApartService/find',//请求
        reader: {
            type: 'json'
        }
    }
});