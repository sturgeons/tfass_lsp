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
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '节拍',
        name: 'JP',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '配送提前时间',
        name: 'PRETIME',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }]
});