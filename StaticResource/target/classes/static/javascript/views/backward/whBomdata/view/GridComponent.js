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
        header: '骨架',
        width: 140,
        dataIndex: 'SKELETON'
    }, {
        header: '发泡总成',
        width: 140,
        dataIndex: 'FAPAO_QADNO'
    }, {
        header: '缝皮总成',
        width: 140,
        dataIndex: 'FENGPI_QADNO'
    }, {
        header: '缝皮车型',
        width: 140,
        dataIndex: 'FENGPI_MODEL'
    }, {
        header: '缝皮总成描述',
        width: 160,
        dataIndex: 'FENGPI_DESC'
    }, {
        header: '装配总成',
        width: 200,
        dataIndex: 'ZHUANGPEI_QADNO'
    }, {
        header: '总成车型',
        dataIndex: 'QAD_MODEL'
    }, {
        header: '总成描述',
        width: 140,
        dataIndex: 'QAD_DESC'
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
                    iconCls: 'add',
                    action: 'add'
                }, {
                    text: '修改',
                    iconCls: 'update',
                    action: 'modify'
                }, '-', {
                    text: '删除',
                    iconCls: 'del',
                    action: 'del'
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