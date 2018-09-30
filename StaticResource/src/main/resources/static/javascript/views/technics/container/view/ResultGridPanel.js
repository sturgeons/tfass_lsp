Ext.define('MainModule.view.ResultGridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.resultgridpanel',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	
    selModel: { checkOnly: true },
    defaults: { sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 60
	}, {
        header: '内容',
        flex: 1,
        dataIndex: 'CONTENT'
    }, {
        header: '文件类型',
        width: 170,
        dataIndex: 'CHECK_TYPE'
    }, {
        header: '检查频次',
        width: 120,
        dataIndex: 'CHECK_FREQUENCY'
    }, {
        header: '样件/检具编号',
        width: 200,
        dataIndex: 'CHECKING_NO'
    }, {
        header: '理论值',
        width: 240,
        dataIndex: 'VAL'
    }, {
        header: '实际值',
        width: 160,
        dataIndex: 'RESULT_VAL'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('MainModule.store.CheckedStore');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            bbar: ['->', {
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