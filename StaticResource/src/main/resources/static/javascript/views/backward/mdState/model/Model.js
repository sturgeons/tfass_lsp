Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	    'SYSID', 'STATE_TYPE', 'OP', 'REMARK', 'STATE_CODE'
    ]
});