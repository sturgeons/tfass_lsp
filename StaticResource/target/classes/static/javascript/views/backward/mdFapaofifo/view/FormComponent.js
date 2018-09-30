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
        allowBlank: false,
        readOnly: false
    },  {
        fieldLabel: '最大数量',
        name: 'MAX_NUM',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    },  {
        fieldLabel: '最小数量',
        name: 'MIN_NUM',
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