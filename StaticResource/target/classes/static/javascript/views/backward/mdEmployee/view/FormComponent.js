Ext.define('LDPlatformModule.view.FormComponent', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formcomponent',
	
    border: false, // 不显示边线
    defaults: { // 组件的默认样式配置
    	xtype: 'textfield',
        labelWidth: 75, // label的默认宽度
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
        fieldLabel: '员工名',
        name: 'EM_NAME',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '员工编号',
        name: 'EM_NO',
        selectOnFocus: true
    }, {
        xtype: 'checkbox',
        fieldLabel: '是否班长',
        name: 'EM_MONITOR',
        inputValue: '1',
        uncheckedValue: '0'
    }]
});