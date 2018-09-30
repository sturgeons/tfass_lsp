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
		sortable : false
	},
	columns : [ {
		xtype : 'rownumberer',
		align : 'center',
		header : '序号',
		width : 50
	}, {
		header : '气袋号',
		width: 160,
		dataIndex : 'QADNO'
	}, {
		header : '布料号',
		width: 140,
		dataIndex : 'FABRIC_NO'
	}, {
		header : '裁片号',
		width: 140,
		dataIndex : 'CUT_NO'
	}, {
		header : '模板号',
		width: 140,
		dataIndex : 'PROG_NO'
	}, {
		header : 'BOM用量',
		dataIndex : 'BOM'
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