Ext.define('LDPlatformModule.view.FormComponent', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formcomponent',
	
    border: false, // 不显示边线
    items: [{
        xtype: 'container',
        layout:'hbox',
        items:[{
            xtype: 'container',
            flex: .45,
            border:false,
            layout: 'anchor',
            defaults: { // 组件的默认样式配置
            	xtype: 'textfield',
                labelWidth: 75, // label的默认宽度
                labelAlign: 'right',
                cls: 'fxstudio-window-inner-margin3',
                labelStyle: 'margin-top:3px;',
                anchor: "98%",
            },
            items: [{
	                fieldLabel: '主键',
	                name: 'ID',
	                hidden: true,
	                hideLabel: true
	            }, {
	            	id: 'prod_line',
                    fieldLabel: '生产线',
                    name: 'LINE',
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.GatherStore'),
                    displayField: 'LINE',
                    valueField: 'LINE',
                    editable: false,
	                allowBlank: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{LINE}</div>',
	                    '</tpl>'
                    )
                }, {
	            	id: 'DEFAULT_INPUT',
	                fieldLabel: '工序',
	                name: 'OP',
	                allowBlank: false,
	                editable: false
	            }, {
                    fieldLabel: '总成号',
                    id: 'qad_combom',
                    name: 'QADNO',
                    queryMode: 'local',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.QadnoStore'),
                    displayField: 'QADNO',
                    valueField: 'QADNO',
                    multiSelect: true,
                    editable: false,
	                allowBlank: false,
                    tpl: Ext.create('Ext.XTemplate',
	                    '<tpl for=".">',
	                     '<div class="x-boundlist-item" style="height:21px">{QADNO}</div>',
	                    '</tpl>'
                    )
                }, {
                    fieldLabel: '文件类型',
                    name: 'CHECK_TYPE',
                    xtype: 'combobox',
                    store: Ext.create('LDPlatformModule.store.ChecktypeStore'),
                    displayField: 'TYPE_NAME',
                    valueField: 'SYSID',
                    allowBlank: false,
                    editable: false
                }, {
	                fieldLabel: '检查内容',
	                name: 'CONTENT',
	                xtype: 'textarea',
	                rows: 11,
	                selectOnFocus: true,
	                allowBlank: false
	            }]
        }, {
            xtype: 'container',
            flex: .55,
            layout: 'anchor',
            defaults: { // 组件的默认样式配置
            	xtype: 'textfield',
                labelWidth: 90, // label的默认宽度
                labelAlign: 'right',
                cls: 'fxstudio-window-inner-margin3',
                labelStyle: 'margin-top:3px;',
                anchor: "98%"
            },
            items: [{
                fieldLabel: '检查类型',
                xtype: 'radiogroup',
                items: [
                    { boxLabel: '数值测量', name: 'DATA_TYPE', inputValue: 1, checked: true},
                    { boxLabel: '逻辑判断', name: 'DATA_TYPE', inputValue: 2 }
                ]
            },{
                fieldLabel: '检查方式',
                name: 'CHECK_METHOD',
                selectOnFocus: true,
                allowBlank: false
            } , {
	                fieldLabel: '检查频次',
	                name: 'CHECK_FREQUENCY',
	                minValue: 0,
	                xtype: 'numberfield',
	                selectOnFocus: true,
	                allowBlank: false
	        }, {
	                fieldLabel: '频次单位',
	                name: 'CHECK_UNIT',
	                selectOnFocus: true,
	                allowBlank: true
	            }, {
	                fieldLabel: '样件/检具编号',
	                name: 'CHECKING_NO',
	                selectOnFocus: true,
	                allowBlank: true
	            },
                {
                    xtype : 'fieldcontainer',
                    fieldLabel: '公差范围',
                    layout: 'hbox',
                    defaults: {
                        hideLabel: false
                    },
                    items : [
                        {
        	                name: 'TOLERANCE_LIMIT_LOWER',
        	                minValue: 0,
        	                flex: 1,
        	                xtype: 'numberfield',
        	                selectOnFocus: true,
        	                decimalPrecision: 4,
        	                allowBlank: true
        	            },{
                            width: 55,
                            xtype: 'combo',
                            queryMode:  'local',
                            forceSelection: true,
                            editable:  false,
                            name:  'LOWER_SIGN',
        	                allowBlank: false,
                            displayField: 'remark',
                            valueField:  'sign',
                            value: "<=",
                            store:  Ext.create('Ext.data.Store', {
                                fields : ['sign', 'remark'],
                                data   : [
                                    {sign : '<=',   remark: '<='},
                                    {sign : '<',  remark: '<'}
                                ]
                            })
                        }, {
                        	value: '公差',
                        	width: 40,
                        	xtype: 'textfield',
                        	readOnly: true,
                        	fieldStyle: 'border:none;'
                        },{
                            width: 55,
                            xtype: 'combo',
                            queryMode:  'local',
                            forceSelection: true,
                            editable:  false,
                            name:  'UPPER_SIGN',
        	                allowBlank: false,
                            displayField: 'remark',
                            valueField:  'sign',
                            value: "<=",
                            store:  Ext.create('Ext.data.Store', {
                                fields : ['sign', 'remark'],
                                data   : [
                                    {sign : '<=',   remark: '<='},
                                    {sign : '<',  remark: '<'}
                                ]
                            })
                        },
                        {
        	                name: 'TOLERANCE_LIMIT_ON',
        	                minValue: 0,
        	                flex: 1,
        	                xtype: 'numberfield',
        	                selectOnFocus: true,
        	                decimalPrecision: 4,
        	                allowBlank: true
        	            }
                    ]
                }, {
	                fieldLabel: '计量单位',
	                name: 'MEASUREMENT_UNIT',
	                xtype: 'combobox',
	                store: Ext.create('LDPlatformModule.store.MUnitStore'),
	                displayField: 'UNIT_NAME',
	                valueField: 'SYSID',
	                allowBlank: true,
	                editable: false
	            }, {
	                fieldLabel: '版本号',
	                name: 'VERSION_NO',
	                selectOnFocus: true,
	                allowBlank: false
	            },  {
	                fieldLabel: '变更内容',
	                name: 'UPDATE_INFO',
	                selectOnFocus: true,
	                allowBlank: true
	            }, {
	                fieldLabel: '变更时间',
	                name: 'UPDATED',
	                xtype: 'datefield',
	                selectOnFocus: true,
	                allowBlank: false,
	                format: 'Y-m-d',
	                width: 180,
	                editable: false,
	                value: new Date()
            }, {
                xtype: 'checkbox',
                fieldLabel: '启用',
                name: 'ACTIVE',
                inputValue: '1',
                uncheckedValue: '0',
                value: '1'
            }]
        }]
    }]
});