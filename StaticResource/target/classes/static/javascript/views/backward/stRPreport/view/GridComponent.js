Ext.define('LDPlatformModule.view.GridComponent', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridcomponent',

	requires: ["Ext.ux.form.field.DateTime"],
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '装配总成',
        width: 160,
        dataIndex: 'QADNO'
    }, {
        header: '检验总数',
        width: 120,
        dataIndex: 'TOTAL'
    }, {
        header: '首检通过数量',
        width: 120,
        dataIndex: 'CROSS_FIRST'
    }, {
        header: '首检返修数量',
        width: 120,
        dataIndex: 'REPAIR_FIRST'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.Store');
        var me = this;

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
            tbar: Ext.create('Ext.toolbar.Toolbar', {
            	items: [
						{
							fieldLabel: '起始日期',
							id: 'begin_date',
							labelWidth: 65,
							labelAlign: 'right',
					        xtype: 'datetimefield',        
					        format: 'Y-m-d H:i', 
					        width: 230,
					        editable: false,
					        value: (function(){
					        		var date = Ext.Date.add(new Date(), Ext.Date.DAY, -1);
					        		      date.setHours(8);
					        		      date.setMinutes(0);
					        		      
					        		return date;
					        })()
						},
						{
							fieldLabel: '结束日期',
							id: 'end_date',
							labelWidth: 65,
							labelAlign: 'right',
					        xtype: 'datetimefield',
					        format: 'Y-m-d H:i',
					        width: 230,
					        editable: false,
					        value: (function(){
					        		var date = new Date();
					        		      date.setHours(8);
					        		      date.setMinutes(0);
					        		      
					        		return date;
					        })()
						}, 
						{
		                    text: '查询信息',
		                    iconCls: 'search',
		                    action: 'search'
		                }, '->', {
		                    text: '缺陷汇总报表',
		                    iconCls: 'excel',
		                    action: 'export',
		                    disabled: true
		                }
            	]
            }),
            bbar: ['->', '查询类型/零件',{
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