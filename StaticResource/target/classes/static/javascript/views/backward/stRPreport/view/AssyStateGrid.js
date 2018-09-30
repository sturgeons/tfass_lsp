Ext.define('LDPlatformModule.view.AssyStateGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.assystategrid',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,

	title: '缺陷状态明细',
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '检验状态',
        width: 160,
        dataIndex: 'ASSY_STATE'
    }, {
        header: '检验数量',
        width: 120,
        dataIndex: 'PART_COUNT'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.AssyStateStore');
        var me = this;

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});