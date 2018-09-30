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
        header: '文件类型',
        width: 140,
        dataIndex: 'TYPE_NAME'
    }, {
        header: '生产线',
        width: 120,
        dataIndex: 'LINE'
    }, {
        header: '工序',
        width: 80,
        dataIndex: 'OP'
    }, {
        header: '总成号',
        width: 300,
        dataIndex: 'QADNO'
    }, {
        header: '检查内容',
        width: 300,
        dataIndex: 'CONTENT'
    }, {
        header: '检查类型',
        width: 90,
        dataIndex: 'DATA_TYPE',
        renderer: function(value, p, r) {
        	return value === 1 ? '数值测量' : '逻辑判断'
        }
    }, {
        header: '检查方式',
        dataIndex: 'CHECK_METHOD'
    }, {
        header: '检查频次',
        width: 80,
        dataIndex: 'CHECK_FREQUENCY'
    }, {
        header: '频次单位',
        width: 80,
        dataIndex: 'CHECK_UNIT'
    }, {
        header: '样件/检具编号',
        width: 160,
        dataIndex: 'CHECKING_NO'
    }, {
        header: '目标值',
        width: 140,
        renderer: function(val, meta, record) {
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
        	return res ===  '目标值' ? ''  : res;
        }
    }, {
        header: '计量单位',
        width: 80,
        dataIndex: 'UNIT_NAME'
    }, {
        header: '版本号',
        width: 70,
        dataIndex: 'VERSION_NO'
    }, {
        header: '更新内容',
        width: 120,
        dataIndex: 'UPDATE_INFO'
    }, {
        header: '更新时间',
        width: 120,
        dataIndex: 'UPDATED'
    }, {
        header: '用户',
        dataIndex: 'EM_NAME'
    }, {
        header: '是否启用',
        dataIndex: 'ACTIVE',
        renderer: function(value, p, r) {
        	return value === '1' ? '是' : '-----'
        }
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.Store');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
                    text: '添加',
                    id: 'add',
                    iconCls: 'add',
                    action: 'add'
                }, {
                    text: '修改',
                    id: 'update',
                    iconCls: 'update',
                    action: 'modify'
                }, '-', {
                    text: '删除',
                    id: 'del',
                    iconCls: 'del',
                    action: 'del'
                }, '->', {
                    fieldLabel: '文件类型',
                    name: 'FILE_TYPE',
                    width: 220,
                    labelWidth: 65,
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.FileTypeStore', {
                    	listeners: {
                    	   	 'load': function(store, records, options) {
                    	            store.insert(0, Ext.create('LDPlatformModule.model.FileTypeModel', {TYPE_NAME:''}));
                    	   	 }
                    	    }
                    }),
                    displayField: 'TYPE_NAME',
                    valueField: 'SYSID',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{TYPE_NAME}</div>',
	                    '</tpl>'
                    )
                }, '-', {
                    fieldLabel: '生产线',
                    name: 'LINE',
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.GatherStore'),
                    width: 200,
                    labelWidth: 45,
                    displayField: 'LINE',
                    valueField: 'LINE',
                    editable: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{LINE}</div>',
	                    '</tpl>'
                    )
                }, '-', {
                	id: 'op_combo',
                    fieldLabel: '工序',
                    width: 140,
                    name: 'OP',
                    labelWidth: 35,
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
                }, '-', 
				{
		            xtype: "combobox",
		            id: 'active',
					labelWidth: 35,
                    width: 150,
		            name: "ACTIVE",
		            fieldLabel: "状态 ",
		            store: Ext.create("Ext.data.Store", {
		                fields: ["Name", "Value"],
		                data: [
		                    { Name: "当前启用 ", Value: "当前启用", },
		                    { Name: "当前停用", Value: "当前停用", }
		                ]
		            }),
		            value: '当前启用' ,
		            editable: false,
		            displayField: "Name",
		            valueField: "Value",
		            queryMode: "local"
		        }]
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