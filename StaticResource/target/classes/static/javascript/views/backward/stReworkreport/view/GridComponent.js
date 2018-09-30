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
        header: '总成条码',
        width: 200,
        dataIndex: 'CONTENT'
    }, {
        header: '缝皮总成',
        width: 160,
        dataIndex: 'FENGPI_QADNO'
    }, {
        header: '发泡总成',
        width: 160,
        dataIndex: 'FAPAO_QADNO'
    }, {
        header: '检验员',
        dataIndex: 'INSPECTOR_NAME'
    }, {
        header: '检验时间',
        width: 160,
        dataIndex: 'ASSY_TIME'
    }, {
        header: '缺陷原因',
        dataIndex: 'ASSY_STATE'
    }, {
        header: '缺陷班组',
        dataIndex: 'TEAMNO'
    }, {
        header: '返修员',
        dataIndex: 'EM_NAME'
    }, {
        header: '返修结果',
        dataIndex: 'REWORK_STATE'
    }, {
        header: '返修确认时间',
        width: 160,
        dataIndex: 'REWORK_TIME'
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
					        width: 210,
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
				            id: 'state',
							labelWidth: 35,
				            name: "state",
				            fieldLabel: "状态",
				            store: Ext.create("Ext.data.Store", {
				                fields: ["Name", "Value"],
				                data: [
				                    { Name: "全部 ", Value: "全部", },
				                    { Name: "首检合格", Value: "首检合格", },
				                    { Name: "首检返修", Value: "首检返修", },
				                    { Name: "返修中", Value: "返修中", },
				                    { Name: "返修合格", Value: "返修合格", },
				                    { Name: "返修报废", Value: "返修报废", }
				                ]
				            }),
				            value: '全部' ,
				            editable: false,
				            displayField: "Name",
				            valueField: "Value",
				            queryMode: "local"
				        }, 
						{
				            xtype: "combobox",
				            id: 'teamno',
							labelWidth: 65,
				            name: "teamno",
				            fieldLabel: "缺陷班组",
				            store: Ext.create("LDPlatformModule.store.TeamStore"),
				            editable: false,
				            displayField: "TEAM_NO",
				            valueField: "TEAM_NO",
				            queryMode: "local"
				        }, 
						{
		                    text: '查询信息',
		                    iconCls: 'search',
		                    action: 'search'
		                },
						'->',
            	        Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me})
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