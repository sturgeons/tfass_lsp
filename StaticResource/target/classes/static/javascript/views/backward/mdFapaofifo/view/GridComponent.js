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
		header : '总成号',
		width: 200,
		dataIndex : 'QADNO'
	}, {
		header : '类型',
		dataIndex : 'QAD_MODEL'
	}, {
		header : '最大数量',
		dataIndex : 'MAX_NUM'
	}, {
		header : '最小数量',
		dataIndex : 'MIN_NUM'
	}, {
		header : '先进先出',
		dataIndex : 'FIFO',
        renderer: function (value, p, r) { return value === '1' ? '是' : '--'; },
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
					text : '修改',
					iconCls : 'update',
					action : 'modify'
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