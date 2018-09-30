Ext.define('LDPlatformModule.view.GridComponent', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridcomponent',
	
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
        header: '总成类型',
        width: 160,
        dataIndex: 'CUST_PARTNO'
    }, {
        header: '总成号',
        width: 160,
        dataIndex: 'QADNO'
    }, {
        header: '数量',
        dataIndex: 'PART_COUNT'
    }, {
        header: '生产批次',
        dataIndex: 'BATCH_NO'
    }, {
        header: '入库单元',
        dataIndex: 'UNIT_NAME'
    }, {
        header: '入库时间',
        width: 160,
        dataIndex: 'CREATED'
    }, {
        header: '标签号',
        width: 360,
        dataIndex: 'CONTENT'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.Store');
        var me = this;

        // Copy properties to Origin Object
        Ext.apply(this, {
            viewConfig:{  
                enableTextSelection:true  
            },  
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
            	items: [
						{
							fieldLabel: '查询开始日期',
							id: 'begin_date',
							labelWidth: 85,
							labelAlign: 'right',
					        xtype: 'datefield',
					        format: 'Y-m-d',
					        width: 200,
					        editable: false,
					        value: new Date()
						},
						{
							fieldLabel: '结束日期',
							id: 'end_date',
							labelWidth: 65,
							labelAlign: 'right',
					        xtype: 'datefield',
					        format: 'Y-m-d',
					        width: 180,
					        editable: false,
					        value: Ext.Date.add(new Date(), Ext.Date.DAY, 1)
						},
						{
		                    text: '查询信息',
		                    iconCls: 'search',
		                    action: 'search'
		                },
						'->',
            	        Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me})
            	]
            }),
            bbar: ['->', '查询类型/零件',{
	                xtype: 'textfield',
	                name: 'searchField',
	                selectOnFocus: true,
	                hideLabel: true,
	                width: 200
	           }, '|', {
	          iconCls: 'x-tbar-loading',
	          style: 'margin-right:20px',
	          listeners: {
	              click: function() {
	                  store.reload();
	              }
	          }
	        }]
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});