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
        header: '零件类型',
        width: 160,
        dataIndex: 'CUST_PARTNO'
    }, {
        header: '总成号',
        width: 160,
        dataIndex: 'QADNO'
    }, {
        header: '计划数量',
        dataIndex: 'PLAN_COUNT'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.Store');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
            		fieldLabel: '计划日期',
            		id: 'plan_date',
            		labelWidth: 75,
            		labelAlign: 'right',
    	   	        xtype: 'datefield',
    	   	        format: 'Y-m-d',
    	   	        width: 180,
    	   	        editable: false,
    	   	        value: new Date()
            	}]
            }),
            bbar: ['->', '查询',{
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