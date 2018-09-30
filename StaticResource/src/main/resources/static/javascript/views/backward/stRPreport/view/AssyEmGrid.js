Ext.define('LDPlatformModule.view.AssyEmGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.assyemgrid',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	
	title: '检验员检验数量',
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '检验员',
        width: 160,
        dataIndex: 'ASSY_EM'
    }, {
        header: '检验数量',
        width: 120,
        dataIndex: 'PART_COUNT'
    }, {
        header: '首检通过数量',
        width: 120,
        dataIndex: 'CROSS_FIRST'
    }, {
        header: '首检返修数量',
        width: 120,
        dataIndex: 'REPAIR_FIRST'
    }, {
        header: '返修合格数量',
        width: 120,
        dataIndex: 'REPAIR_OK'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.AssyEmStore');
        var me = this;

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});