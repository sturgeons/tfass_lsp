Ext.define('LDPlatformModule.view.GridComponent', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridcomponent',

	enableColumnHide : false,
	sortableColumns : false,
	enableColumnMove : false,
	
	renderFunc: function(pre, next) {
		var content =  pre + " >>> " + next;
		
		if(pre  != next) {
			return  "<span style='color:red;font-weight:bolder;'>" + content + "</span>";
		} 
		return content;
	},

	columns : [ {
		xtype : 'rownumberer',
		align : 'center',
		header : '序号',
		width : 50
	}, {
		header : '修改人',
		dataIndex : 'USERNAME'
	}, {
		header : '生产线',
		width : 240,
		renderer: function(val, meta, rec) {
			return this.renderFunc(rec.get("OLD_LINE"), rec.get("NEW_LINE"));
		}
	},  {
		header : '零件号',
		width: 240,
		renderer: function(val, meta, rec) {
			return this.renderFunc(rec.get("OLD_PART_ID"), rec.get("NEW_PART_ID"));
		}
	}, {
		header : '零件数量',
		width: 140,
		renderer: function(val, meta, rec) {
			return this.renderFunc(rec.get("OLD_QUANTITY"), rec.get("NEW_QUANTITY"));
		}
	}, {
		header : '最小值',
		width: 140,
		renderer: function(val, meta, rec) {
			return this.renderFunc(rec.get("OLD_MIN_QUANTITY"), rec.get("NEW_MIN_QUANTITY"));
		}
	}, {
		header : '最大补料数',
		width: 160,
		renderer: function(val, meta, rec) {
			return this.renderFunc(rec.get("OLD_MAX_SUPPLYMENT"), rec.get("NEW_MAX_SUPPLYMENT"));
		}
	}, {
		header : '修改原因',
		dataIndex : 'REASON_ID'
	}, {
		header : '修改时间',
		width: 140,
		dataIndex : 'CREATED'
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
				items : [ '->', {
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