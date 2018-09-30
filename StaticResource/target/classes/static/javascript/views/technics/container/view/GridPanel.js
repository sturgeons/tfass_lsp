Ext.define('MainModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,

	id: 'dataGrid',
    selModel: { checkOnly: true },
    defaults: { sortable: true },
    viewConfig:{
        stripeRows: false,
        getRowClass: function(record,  rowIndex){ 
        	return record.get("STATUS") === '2' ?  "invalid-row" : "";
       } 
    },
    columns: [{ 
        header: '工序号',
        width: 100,
        dataIndex: 'OP'
	},  {
        header: '内容',
        flex: 1,
        dataIndex: 'CONTENT'
    }, {
        header: '文件类型',
        width: 170,
        dataIndex: 'CHECK_TYPE'
    }, {
        header: '样件/检具编号',
        width: 220,
        dataIndex: 'CHECKING_NO'
    }, {
        header: '目标值',
        width: 300,
        renderer: function(value, meta, record) {
        	meta.style = "font-size:14pt";
        	if(record.get('DATA_TYPE') === 2) {
      		  		return "合格";
	      	}
	      	
	      	var low = record.get('TOLERANCE_LIMIT_LOWER');
	      	var upper = record.get('TOLERANCE_LIMIT_ON');
	      	var res = "";
	      	
	      	if(low.toString().length > 0) {
	      		res += low + " "+ record.get('LOWER_SIGN') + " ";
	      	}
	      	res += '目标值';
	      	if(upper.toString().length > 0) {
	      		res += " " + record.get('UPPER_SIGN') + " " + upper 
	      	}
        	return res ===  '目标值' ? ''  : "("+ res + ")" + record.get('UNIT_NAME');
        }
    }, {
        header: '实际值',
        width: 140,
        dataIndex: 'RESULT_VAL'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('MainModule.store.Store');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
            	defaults: {
            		labelStyle: 'font-size:16pt;margin: 12px 5px',
            	},
                items: [{
                    fieldLabel: '生产线',
                    name: 'LINE',
                    id: 'line_combo',
                    width: 220,
                    labelWidth: 80,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('MainModule.store.LineStore'),
                    displayField: 'LINE',
                    valueField: 'LINE',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{LINE}</div>',
	                    '</tpl>'
                    )
                }, {
                    fieldLabel: '产品',
                    labelWidth: 60,
                    width: 360,
                    id: 'qadno_combo',
                    name: 'QADNO',
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('MainModule.store.QadnoStore'),
                    displayField: 'QADNO',
                    valueField: 'QADNO',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{QADNO}</div>',
	                    '</tpl>'
                    )
                }, '-',  {
                    fieldLabel: '工序',
                    id: 'op_combo',
                    name: 'OP',
                    width: 200,
                    labelWidth: 60,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('MainModule.store.OPStore'),
                    displayField: 'OP',
                    valueField: 'OP',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{OP}</div>',
	                    '</tpl>'
                    )
                }, '-', {
            		fieldLabel: '日期',
            		labelAlign: 'right',
                    labelWidth: 60,
    	   	        xtype: 'datefield',
    	   	        format: 'Y-m-d',
    	   	        width: 220,
    	   	        editable: false,
    	   	        value: Ext.Date.add(new Date(), Ext.Date.HOUR, -6)
            	},  '-', {
                    fieldLabel: '班次',
                    id: 'shift',
                    name: 'SHIFT_NAME',
                    labelWidth: 55,
                    width: 240,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('MainModule.store.ShiftStore'),
                    displayField: 'SHIFT_NAME',
                    valueField: 'SHIFT_NAME',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{SHIFT_NAME}</div>',
	                    '</tpl>'
                    ), 
                    listeners: {
	                    afterRender : function(comp) {
	                    	/*var store = Ext.data.StoreManager.lookup('ShiftStore');
	                    	// 设定班次的默认值，从用户登录时间获取
	                    	store.on('load', function() {
	                    			store.each(function(rec) {
	                    					if(rec.get('SELECTED')) {
	                    						comp.setValue(rec.get('SHIFT_NAME'));
	                    						return false;
	                    					}
	                    			});
	                    	})*/
	                     }
                   }
                }, '-', {
                    fieldLabel: '文件类型',
                    name: 'CHECK_TYPE',
                    width: 320,
                    labelWidth: 110,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('MainModule.store.CheckTypeStore'),
                    displayField: 'TYPE_NAME',
                    valueField: 'SYSID',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{TYPE_NAME}</div>',
	                    '</tpl>'
                    )
                },  '->',  {
					text : '提交变更',
					iconCls : 'fx-chk-commit',
					disabled: true,
					cls: 'fx-chk-button',
					action : 'commit'
				}, '|',{
					text : '取消变更',
					iconCls : 'fx-chk-clear',
					cls: 'fx-chk-button',
					disabled: true,
					action : 'reset'
				}, '-']
            }),
            bbar: ['->', {
  	          iconCls: 'x-tbar-loading',
  	          style: 'margin-right:20px',
  	          listeners: {
  	              click: function() {
  	            	  if(store.lastOptions) {
  	            		  store.reload();
  	            	  }
  	              }
  	          }
  	        }]
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});