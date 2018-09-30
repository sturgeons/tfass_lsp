Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	    'SYSID', 'FABRIC_NO', 'REMARK'
    ]
});