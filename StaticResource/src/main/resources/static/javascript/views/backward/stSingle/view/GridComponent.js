Ext.define('LDPlatformModule.view.GridComponent', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridcomponent',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	rowLines: false,
	columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, { 
        header: '零件号',
    	width: 160,
        dataIndex: 'QADNO'
	},{ 
        header: '条码信息',
    	width: 200,
        dataIndex: 'CONTENT'
	},  { 
        header: '检验员',
        dataIndex: 'ASSY_EM'
	},  { 
        header: '检验状态',
        dataIndex: 'ASSY_STATE'
	},  {
        header: '检验时间',
    	width: 160,
        dataIndex: 'ASSY_TIME',
        renderer: function(val) {
        	return val ? Ext.Date.format(new Date(val), 'Y-m-d H:i:s') : val;
        } 
    },  {
        header: '返修员',
        dataIndex: 'REWORK_EM'
    }, { 
        header: '返修状态',
        dataIndex: 'REWORK_STATE'
	}, { 
        header: '确认时间',
    	width: 160,
        dataIndex: 'REWORK_TIME',
        renderer: function(val) {
        	return val ? Ext.Date.format(new Date(val), 'Y-m-d H:i:s') : val;
        } 
	}, {
        header: '包装状态',
        dataIndex: 'PACK_STATE'
    }, {
        header: '包装时间',
    	width: 160,
        dataIndex: 'PACK_TIME',
        renderer: function(val) {
        	return val ? Ext.Date.format(new Date(val), 'Y-m-d H:i:s') : val;
        } 
    }, {
        header: '班组',
        dataIndex: 'TEAMNO'
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
            bbar: [Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me}), '->', {
	          iconCls: 'x-tbar-loading',
	          style: 'margin-right:20px',
	          listeners: {
	              click: function() {
	                  store.reload();
	              }
	          }
	        }],
	        tbar: Ext.create('Ext.toolbar.Toolbar', {
	            items: [{
	            	fieldLabel: '条码信息',
	            	labelWidth: 65,
	            	xtype: 'textfield',
	            	width: 300,
	            	name: 'barcode'
	            }, '-', {
                    text: '查询',
                    iconCls: 'search',
                    action: 'search'
                }]
	        })
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});