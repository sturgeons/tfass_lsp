Ext.define('MenuModule.view.MenuGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.menugrid',
	
    requires: ["Ext.plugins.Paging"],
	
    selModel: { checkOnly: true },
    defaults: { sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '菜单名称',
        width: 220,
        dataIndex: 'menuname'
    }, {
        id: 'itemLink',
        header: '菜单描述',
        width: 300,
        dataIndex: 'remark'
    }, {
        header: '锁定',
        width: 75,
        renderer: function (value, p, r) { return value === '1' ? '是' : '--'; },
        dataIndex: 'isLock'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('MenuModule.store.Menu');

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
            bbar: { // Bottom bar
                xtype: 'paging',
                store: store
            }
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});