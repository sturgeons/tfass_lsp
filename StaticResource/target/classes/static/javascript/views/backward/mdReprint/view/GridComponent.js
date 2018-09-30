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
        header: '单号',
        width: 160,
        dataIndex: 'RECORD_NO'
    }, {
        header: '打印时间',
        width: 160,
        dataIndex: 'PRINT_DATE'
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
                    text: '料单补打',
                    iconCls: 'printer',
                    action: 'print'
                }, '->', {
            		fieldLabel: '料单日期',
            		labelWidth: 75,
            		labelAlign: 'right',
    	   	        xtype: 'datefield',
    	   	        format: 'Ymd',
    	   	        width: 180,
    	   	        editable: false,
    	   	        value: new Date()
            	}]
            }),
            bbar: ['->', '包含零件',{
	                xtype: 'textfield',
	                name: 'searchField',
	                selectOnFocus: true,
	                hideLabel: true,
	                width: 200,
	                fieldStyle: 'text-transform:uppercase'
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