Ext.define('LDPlatformModule.model.Model', {
	extend: 'Ext.data.Model',
	idProperty: 'SYSID',
	idgen:  Ext.create('Ext.ux.UUIDGenerator'),
	fields: [
	         'SKELETON', 'FAPAO_QADNO', 'FENGPI_QADNO', 'FENGPI_MODEL', 
	         'FENGPI_DESC', 'ZHUANGPEI_QADNO', 'QAD_MODEL', 'QAD_DESC'
    ]
});