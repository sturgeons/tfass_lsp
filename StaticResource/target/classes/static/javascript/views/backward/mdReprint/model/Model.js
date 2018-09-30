Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	    'RECORD_NO', 'CONTENT', 'PRINT_DATE'
    ]
});