Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	fields: [
	    'SYSID', 'LINE', 'PART_ID', 'PARTNO', 'QUANTITY', 'MIN_QUANTITY',
	    'MAX_SUPPLYMENT', 'REMARK', 'REASON_ID', 'EM_ID', 'OP'
    ]
});