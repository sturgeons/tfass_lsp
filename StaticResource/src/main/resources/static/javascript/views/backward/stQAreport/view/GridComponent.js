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
        header: '提交日期',
    	width: 90,
        dataIndex: 'CREATED'
	},{ 
        header: '生产线',
        dataIndex: 'LINE'
	},  { 
        header: '产品',
        width: 160,
        dataIndex: 'QADNO'
	},  { 
        header: '工序',
        width: 70,
        dataIndex: 'OP'
	},  {
        header: '文件类型',
        width: 120,
        dataIndex: 'CHECK_TYPE'
    },  {
        header: '检查内容',
        width: 360,
        dataIndex: 'CONTENT'
    }, { 
        header: '班次',
    	width: 50,
        dataIndex: 'SHIFT'
	}, { 
        header: '填写人',
    	width: 90,
        dataIndex: 'EM_NAME'
	}, {
        header: '实际值',
        width: 100,
        dataIndex: 'RESULT_VAL'
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
	                name: 'BEGIN_DATE',
	        		fieldLabel: '开始日期',
	        		labelAlign: 'right',
	                labelWidth: 60,
		   	        xtype: 'datefield',
		   	        format: 'Y-m-d',
		   	        width: 170,
		   	        editable: false,
    	   	        value: Ext.Date.add(new Date(), Ext.Date.DAY, -1)
	        	},  '|', {
	                name: 'END_DATE',
	        		fieldLabel: '结束日期',
	        		labelAlign: 'right',
	                labelWidth: 60,
		   	        xtype: 'datefield',
		   	        format: 'Y-m-d',
		   	        width: 170,
		   	        editable: false,
    	   	        value: Ext.Date.add(new Date())
	        	}, '-', {
	                fieldLabel: '生产线',
	                name: 'LINE',
	                id: 'line_combo',
	                width: 180,
	                labelWidth: 55,
	                queryMode: 'local',
	                xtype: 'combobox',
	                store: Ext.create('LDPlatformModule.store.LineStore'),
	                displayField: 'LINE',
	                valueField: 'LINE',
	                editable: false,
	                tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{LINE}</div>',
	                    '</tpl>'
	                )
	            },  '-', {
                	id: 'op_combo',
                    fieldLabel: '工序',
                    name: 'OP',
                    labelWidth: 35,
	                width: 120,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.OPStore'),
                    displayField: 'OP',
                    valueField: 'OP',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{OP}</div>',
	                    '</tpl>'
                    )
                }, '-', {
	                fieldLabel: '班次',
	                id: 'shift',
	                name: 'SHIFT_NAME',
	                labelWidth: 45,
	                width: 120,
	                queryMode: 'local',
	                xtype: 'combobox',
	                store: Ext.create('LDPlatformModule.store.ShiftStore'),
	                displayField: 'SHIFT_NAME',
	                valueField: 'SHIFT_NAME',
	                editable: false,
	                tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{SHIFT_NAME}</div>',
	                    '</tpl>'
	                )
	            },  {
                    fieldLabel: '文件类型',
                    name: 'CHECK_TYPE',
                    labelWidth: 65,
                    width: 200,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.CheckTypeStore', {
                    	listeners: {
                    	   	 'load': function(store, records, options) {
                    	            store.insert(0, Ext.create('LDPlatformModule.model.CheckTypeModel', {TYPE_NAME:''}));
                    	   	 }
                    	    }
                    }),
                    displayField: 'TYPE_NAME',
                    valueField: 'TYPE_NAME',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{TYPE_NAME}</div>',
	                    '</tpl>'
                    )
                }]
	        })
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});