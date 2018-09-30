Ext.define('LDPlatformModule.view.QualityGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.qualitygrid',
	
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
        flex: 1,
        dataIndex: 'LINE'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.QualityStore');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            selType: 'checkboxmodel',
            selModel: {
            	allowDeselect: true,
                mode: "SIMPLE", 
                enableKeyNav: false
            }
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});