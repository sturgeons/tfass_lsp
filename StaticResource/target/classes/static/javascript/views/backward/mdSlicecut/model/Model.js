Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	    'SYSID', 'CUT_NO', 'REMARK', 'FIFO', 'CUT_COUNT',  'PROG_NO'
    ]
});