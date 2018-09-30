Ext.define('LDPlatformModule.view.TeamnoGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.teamnogrid',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,

	title: '缺陷班组明细',
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '班组',
        width: 160,
        dataIndex: 'TEAMNO'
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
        var store = Ext.create('LDPlatformModule.store.TeamnoStore');
        var me = this;

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});