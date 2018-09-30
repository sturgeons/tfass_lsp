Ext.define('MainModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'MainModule.view.GridPanel',
        'MainModule.view.ResultGridPanel',
        'MainModule.view.UserPanel'
    ],

    layout: 'border',
    items: [{
    	title: '用户信息',
        xtype: 'userpanel',
        region: 'west'
     }, {
    	 region: 'center',
    	 layout: 'fit',
    	 items : [Ext.create('Ext.tab.Panel', {
    		    tabPosition: 'bottom',
    		    items: [{
    		    	title: '待确认工艺文件',
    		    	layout: 'fit',
    		    	items: Ext.create( 'MainModule.view.GridPanel')
    		     },{
    		     	title: '已确认工艺文件',
    		    	layout: 'fit',
    		    	items: Ext.create( 'MainModule.view.ResultGridPanel')
    		    }],
    		    listeners: {
    		    	tabchange: function(panel, card) {
    		    		if(card.title === '已确认工艺文件') {
    		    				Ext.getCmp('commit_btn').setVisible(false);
    		    				Ext.getCmp('data_filter').setVisible(false);
		    				    Ext.getCmp('complete_filter').setVisible(true);
    		    				Ext.getCmp('shift').getStore().load().on('load', function(records) {
    		    					records.each(function(rec) {
	                    					if(rec.get('SELECTED')) {
	                    						Ext.getCmp('shift').setValue(rec.get('SHIFT_NAME'));
	                    						return false;
	                    					}
	                    			});
    		    				    Ext.getCmp('date_field').setValue(new Date());
    			 	        		Ext.getCmp('date_field').setDisabled(false);
    			 	        		Ext.getCmp('shift').setDisabled(false);
    			    				Ext.getCmp('line_combo').setValue('');
    		    				});
    		    		} else {
		    				    Ext.getCmp('commit_btn').setVisible(true);
		    				    Ext.getCmp('data_filter').setVisible(true);
			 	        		Ext.getCmp('date_field').setDisabled(true);
			 	        		Ext.getCmp('shift').setDisabled(true);
    		    				Ext.getCmp('complete_filter').setVisible(false);
    		    				Ext.getCmp('shift').setValue(null);
		    				    Ext.getCmp('date_field').setValue(null);
			    				Ext.getCmp('line_combo').setValue('');
    		    		}
	    				Ext.getCmp('complete_filter').setValue('');
    		    	}
    		    }
		})],
        tbar: Ext.create('Ext.toolbar.Toolbar', {
            items: [{
                fieldLabel: '生产线',
                name: 'LINE',
                id: 'line_combo',
                width: 240,
                labelWidth: 55,
                queryMode: 'local',
                xtype: 'combobox',
                store: Ext.create('MainModule.store.LineStore'),
                displayField: 'LINE',
                valueField: 'LINE',
                editable: false,
                tpl: Ext.create('Ext.XTemplate',
                    '<tpl for=".">',
                     '<div class="x-boundlist-item" style="height:21px">{LINE}</div>',
                    '</tpl>'
                )
            },  '-', {
            	id: 'date_field',
        		fieldLabel: '日期',
        		labelAlign: 'right',
                disabled: true,
                labelWidth: 35,
	   	        xtype: 'datefield',
	   	        format: 'Y-m-d',
	   	        width: 160,
	   	        editable: false
        	}, {
				iconCls : 'clear',
				action : 'clear'
		    	
		    },  '-', {
                fieldLabel: '班次',
                id: 'shift',
                disabled: true,
                name: 'SHIFT_NAME',
                labelWidth: 35,
                width: 240,
                queryMode: 'local',
                xtype: 'combobox',
                store: Ext.create('MainModule.store.ShiftStore'),
                displayField: 'SHIFT_NAME',
                valueField: 'SHIFT_NAME',
                editable: false,
                tpl: Ext.create('Ext.XTemplate',
                    '<tpl for=".">',
                     '<div class="x-boundlist-item" style="height:21px">{SHIFT_NAME}</div>',
                    '</tpl>'
                )
            }, '-', Ext.create('Ext.form.ComboBox', {
                fieldLabel: '数据状态',
                id: 'data_filter',
                disabled: true,
                labelWidth: 75,
                name: 'DATA_FILTER',
                width: 240,
                store:  Ext.create('Ext.data.Store', {
                    fields: ['val'],
                    data : [
                        {"val":""},
                        {"val":"已填合格"},
                        {"val":"已填未合格"},
                        {"val":"漏填"}
                    ]
                }),
                queryMode: 'local',
                displayField: 'val',
                valueField: 'val',
                editable: false,
                tpl: Ext.create('Ext.XTemplate',
                    '<tpl for=".">',
                     '<div class="x-boundlist-item" style="height:21px">{val}</div>',
                    '</tpl>'
                )
            }), Ext.create('Ext.form.ComboBox', {
                fieldLabel: '数据状态',
                id: 'complete_filter',
                disabled: true,
                hidden: true,
                labelWidth: 75,
                name: 'COMPLETE_FILTER',
                width: 240,
                store:  Ext.create('Ext.data.Store', {
                    fields: ['val'],
                    data : [
                        {"val":""},
                        {"val":"已填合格"},
                        {"val":"已填未合格"}
                    ]
                }),
                queryMode: 'local',
                displayField: 'val',
                valueField: 'val',
                editable: false,
                tpl: Ext.create('Ext.XTemplate',
                    '<tpl for=".">',
                     '<div class="x-boundlist-item" style="height:21px">{val}</div>',
                    '</tpl>'
                )
            }), '->',  {
            	id: 'remove_btn',
                text: '删除文件',
                disabled: true,
                style: 'margin-right: 40px',
                iconCls: 'del',
                action: 'remove'
            },{
            	id: 'commit_btn',
                text: '确认文件',
                disabled: true,
                iconCls: 'commit',
                action: 'confirm'
            }]
        })
     }]
});
