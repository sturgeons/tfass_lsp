Ext.define('LDPlatformModule.view.FormComponent', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formcomponent',
	
    border: false, // 不显示边线
    defaults: { // 组件的默认样式配置
    	xtype: 'textfield',
        labelWidth: 85, // label的默认宽度
        labelAlign: 'right',
        cls: 'fxstudio-window-inner-margin3',
        labelStyle: 'margin-top:3px;',
        anchor: "98%"
    },
    items: [{
        fieldLabel: '主键',
        name: 'SYSID',
        hidden: true,
        hideLabel: true
    }, {
        id: 'DEFAULT_INPUT',
        fieldLabel: '生产线',
        name: 'LINE',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.LineStore'),
        displayField: 'LINE',
        valueField: 'LINE',
        allowBlank: false,
        editable: false
    }, {
        fieldLabel: '工序',
        name: 'OP',
        queryMode: 'local',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.OPStore'),
        displayField: 'OP',
        valueField: 'OP',
        allowBlank: false,
        editable: false
    }, {
        fieldLabel: '总成号',
        name: 'QAD_ID',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.QadStore'),
        displayField: 'QADNO',
        valueField: 'SYSID',
        allowBlank: false,
        editable: false
    }, {
        fieldLabel: '零件号',
        name: 'PART_ID',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.PartStore'),
        displayField: 'PARTNO',
        valueField: 'SYSID',
        allowBlank: false,
        editable: false
    },  {
        fieldLabel: 'BOM',
        name: 'BOM',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '小时消耗量',
        name: 'CONSUME_HOUR',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    },{
        xtype: 'checkbox',
        fieldLabel: '参与拉动',
        name: 'ACTIVE',
        inputValue: '1',
        uncheckedValue: '0'
    }]
});