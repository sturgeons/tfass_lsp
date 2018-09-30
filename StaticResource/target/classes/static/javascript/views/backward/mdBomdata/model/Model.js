Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	fields: [
	    'SYSID', 'LINE', 'OP', 'QAD_ID', 'QADNO', 'PART_ID', 'PARTNO',
	    'CONSUME_HOUR', 'BOM',  'ACTIVE', 'REMARK'
    ]
});