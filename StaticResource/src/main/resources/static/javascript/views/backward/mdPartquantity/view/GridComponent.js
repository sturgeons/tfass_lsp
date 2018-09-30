Ext.define('LDPlatformModule.view.GridComponent', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridcomponent',

	enableColumnHide : false,
	sortableColumns : false,
	enableColumnMove : false,

	selModel : {
		checkOnly : true
	},
	defaults : {
		sortable : true
	},
	columns : [ {
		xtype : 'rownumberer',
		align : 'center',
		header : '序号',
		width : 50
	}, {
		header : '生产线',
		dataIndex : 'LINE',
		width : 120
	}, {
		header : '工序',
		dataIndex : 'OP',
		width : 90
	},  {
		header : '零件号',
		width: 160,
		dataIndex : 'PARTNO'
	}, {
		header : '当前数量',
		width: 160,
		dataIndex : 'QUANTITY'
	}, {
		header : '最小值',
		width: 160,
		dataIndex : 'MIN_QUANTITY'
	}, {
		header : '最大补料数',
		width: 160,
		dataIndex : 'MAX_SUPPLYMENT'
	}, {
		header : '零件名称',
		width: 160,
		dataIndex : 'REMARK'
	}],

	/**
	 * Component Init
	 */
	initComponent : function() {
		// Create Store Object
		var store = Ext.create('LDPlatformModule.store.Store');

		// Copy properties to Origin Object
		Ext.apply(this, {
			store : store,
			tbar : Ext.create('Ext.toolbar.Toolbar', {
				items : [ {
					text : '添加',
					iconCls : 'add',
					action : 'add'
				}, {
					text : '修改',
					iconCls : 'update',
					action : 'modify'
				}, '-', {
					text : '删除',
					iconCls : 'del',
					action : 'del'
				} , '->', {
			        fieldLabel: '生产线',
			        labelWidth: 55,
			        xtype: 'combobox',
			        store: Ext.create('LDPlatformModule.store.LineStore'),
			        displayField: 'LINE',
			        valueField: 'LINE'
			    }, {
					text : '清除',
					iconCls : 'clear',
					action : 'clear'
			    	
			    }]
			}),
			bbar : [ '->', '查询', {
				xtype : 'textfield',
				name : 'searchField',
				selectOnFocus : true,
				hideLabel : true,
				width : 200
			}, '|', {
				iconCls : 'x-tbar-loading',
				style : 'margin-right:20px',
				listeners : {
					click : function() {
						store.reload();
					}
				}
			} ]
		});
		// Call Parent Constructor
		this.callParent(arguments);
	}
});