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
        fieldLabel: '总成号',
        name: 'QADNO',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.PartStore'),
        displayField: 'QADNO',
        valueField: 'QADNO',
        allowBlank: false,
        editable: false
    },  {
        fieldLabel: '最低库存',
        name: 'MIN_STORE',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    },  {
        fieldLabel: '最高库存',
        name: 'MAX_STORE',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    },  {
        fieldLabel: '摆放箱数',
        name: 'VOLUME',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }, {
        xtype: 'checkbox',
        fieldLabel: '先进先出',
        name: 'FIFO',
        inputValue: '1',
        uncheckedValue: '0'
    }]
});