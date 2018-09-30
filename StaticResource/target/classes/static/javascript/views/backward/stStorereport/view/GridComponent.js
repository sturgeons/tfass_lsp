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
        header: '总成号',
        width: 160,
        dataIndex: 'QADNO'
    }, {
        header: '数量',
        width: 200,
        dataIndex: 'PART_COUNT'
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
				            xtype: "combobox",
				            id: 'cate',
							labelWidth: 65,
				            name: "cate",
				            fieldLabel: "查询项目",
				            store: Ext.create("Ext.data.Store", {
				                fields: ["Name", "Value"],
				                data: [
				                    { Name: "发泡入库数量汇总 ", Value: "发泡入库数量汇总", },
				                    { Name: "发泡出库数量汇总", Value: "发泡出库数量汇总", },
				                    { Name: "缝制出库数量汇总", Value: "缝制出库数量汇总", },
				                    { Name: "裁片入库数量汇总", Value: "裁片入库数量汇总", },
				                    { Name: "裁片出库数量汇总", Value: "裁片出库数量汇总", },
				                    { Name: "气袋入库数量汇总", Value: "气袋入库数量汇总", },
				                    { Name: "气袋出库数量汇总", Value: "气袋出库数量汇总", }
				                ]
				            }),
				            value: '发泡入库数量汇总' ,
				            editable: false,
				            displayField: "Name",
				            valueField: "Value",
				            queryMode: "local"
				        }, 
						{
		                    text: '查询信息',
		                    iconCls: 'search',
		                    action: 'search'
		                },
						'->',
            	        Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me })
            	]
            }),
            bbar: ['->', '查询零件',{
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