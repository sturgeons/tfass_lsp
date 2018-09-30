Ext.define('MainModule.model.Model', {
	extend: 'Ext.data.Model',
	fields: [
	    'ID', 'LINE', 'OP', 'QADNO', 'CONTENT','CHECK_TYPE', 
	    'CHECK_METHOD', 'CHECK_FREQUENCY', 'CHECKING_NO',
	    'VAL', 'RESULT_VAL', 'SYSID', 'EM_ID', 'DATA_TYPE', 'STATUS',
	    'SHIFT_NAME', 'LOWER_SIGN', "UPPER_SIGN", "UNIT_NAME",
	    "TOLERANCE_LIMIT_LOWER", "TOLERANCE_LIMIT_ON"
    ]
});