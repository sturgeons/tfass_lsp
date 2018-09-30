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
		dataIndex : 'QADNO',
		width : 120
	},  {
		header : '最低库存',
		dataIndex : 'MIN_STORE'
	}, {
		header : '最高库存',
		dataIndex : 'MAX_STORE'
	}, {
		header : '摆放箱数',
		dataIndex : 'VOLUME'
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