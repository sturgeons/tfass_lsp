Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	fields: [
	    'SYSID', 'REC_ID', 'OLD_LINE', 'NEW_LINE', 'OLD_PART_ID', 'NEW_PART_ID',
	    'OLD_QUANTITY', 'NEW_QUANTITY', 'OLD_MIN_QUANTITY', 'NEW_MIN_QUANTITY',
	    'OLD_MAX_SUPPLYMENT', 'NEW_MAX_SUPPLYMENT', 'REASON_ID', 'CREATED',
	    'USERNAME'
    ]
});