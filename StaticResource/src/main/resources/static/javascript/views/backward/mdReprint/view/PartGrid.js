Ext.define('LDPlatformModule.view.PartGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.partgrid',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	
    selModel: { checkOnly: true },
    defaults: { sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '零件号',
        width: 160,
        dataIndex: 'partno'
    }, {
        header: '当前数量',
        dataIndex: 'qty',
    	width: 80
    }, {
        header: '安全数量',
        dataIndex: 'qty_min',
    	width: 80
    }, {
        header: '生产线',
        dataIndex: 'line'
    }, {
        header: '请求时间',
        dataIndex: 'time'
    }, {
        header: '架子号',
        dataIndex: 'location'
    }, {
        header: '需求数量',
        dataIndex: 'reqty',
    	width: 80
    }, {
        header: '包装数',
        dataIndex: 'pack',
    	width: 80
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Copy properties to Origin Object
        Ext.apply(this, {
        	store: Ext.create("LDPlatformModule.store.PartStore"),
        	tbar: [ '<strong>料单明细列表</strong>' ]
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});