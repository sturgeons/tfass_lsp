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
        dataIndex: 'QAD_TYPE'
    }, {
        header: '总成号',
        width: 160,
        dataIndex: 'QAD_NO'
    }, {
        header: '计划数量',
        dataIndex: 'PLAN_COUNT'
    }, {
        header: '入库数量',
        dataIndex: 'IN_COUNT'
    }, {
        header: '出库数量',
        dataIndex: 'OUT_COUNT'
    }, {
        header: '当前库存量',
        dataIndex: 'CUR_COUNT'
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
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
            	items: [Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me})]
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