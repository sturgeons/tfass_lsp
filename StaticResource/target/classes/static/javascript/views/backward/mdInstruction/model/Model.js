Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'QADNO',
	fields: [
	    'PLAN_DATE', 'QADNO', 'PLAN_COUNT', 'CUST_PARTNO'
    ]
});