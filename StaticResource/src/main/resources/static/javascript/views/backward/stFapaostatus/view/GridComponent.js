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
        header: '库位',
        width: 60,
        dataIndex: 'UNIT_NAME'
    }, {
        header: '总成号',
        width: 160,
        dataIndex: 'QADNO'
    }, {
        header: '数量',
        width: 60,
        dataIndex: 'PART_COUNT'
    }, {
        header: '扫描时间',
        width: 140,
        dataIndex: 'CREATED',
        renderer: function(value) {
        	return Ext.util.Format.date(new Date(value), "Y-m-d H:i:s");
        }
    }, {
        header: '批次号',
        dataIndex: 'BATCH_NO'
    }, {
        header: '条码标识',
        width: 140,
        dataIndex: 'RECORD_NO'
    }, {
        header: '扫描信息',
        width: 450,
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
            	items: [Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me})]
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