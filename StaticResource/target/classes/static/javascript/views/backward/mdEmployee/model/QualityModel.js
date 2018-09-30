Ext.define('LDPlatformModule.model.QualityModel', {
	extend : 'Ext.data.Model',
	fields : [ 'ID', 'LINE', 'OP', 'QADNO', 'CONTENT', 'CHECK_TYPE',
			'CHECK_METHOD', '', 'CHECK_FREQUENCY', 'CHECK_UNIT', 'CHECKING_NO',
			'TOLERANCE_LIMIT_LOWER', 'TOLERANCE_LIMIT_ON', 'MEASUREMENT_UNIT',
			'VERSION_NO', 'STATUS', 'UPDATE_INFO', "UPDATED", "EM_ID"]
});