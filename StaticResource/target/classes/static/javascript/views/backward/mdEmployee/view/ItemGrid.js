Ext.define('LDPlatformModule.view.ItemGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.itemgrid',
	
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
        header: '生产线',
        dataIndex: 'LINE'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.ItemStore');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
                	id: 'bind',
                    text: '绑定生产线',
                    iconCls: 'add',
                    action: 'bind'
                }, '-', {
                	id: 'unbind',
                    text: '解除绑定',
                    iconCls: 'del',
                    action: 'unbind',
                    disabled: true
                }]
            }),
            bbar: ['->',{
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