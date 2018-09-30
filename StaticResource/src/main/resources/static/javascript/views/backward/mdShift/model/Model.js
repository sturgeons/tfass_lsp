Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	fields: [
	    'SYSID', 'SHIFT_NAME', 'SHIFT_BEGIN', 'SHIFT_END', 'SHIFT_INDEX',
	    'BEGIN_HOUR', 'BEGIN_MINUTE', 'END_HOUR', 'END_MINUTE'
    ]
});