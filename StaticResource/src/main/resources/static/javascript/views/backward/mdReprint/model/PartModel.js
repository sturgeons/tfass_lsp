Ext.define('LDPlatformModule.model.PartModel', {
	extend: 'Ext.data.Model',
	fields: [
	    'partno', 'qty', 'qty_min', 'line',
	    'time', 'location', 'reqty', 'pack'
    ]
});