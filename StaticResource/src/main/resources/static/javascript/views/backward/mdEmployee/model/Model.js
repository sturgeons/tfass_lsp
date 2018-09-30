Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	    'SYSID', 'EM_NAME', 'EM_NO', 'EM_MONITOR'
    ]
});