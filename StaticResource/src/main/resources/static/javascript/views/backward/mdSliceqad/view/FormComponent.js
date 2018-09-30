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
        fieldLabel: '气袋号',
        name: 'QADNO',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '备注',
        name: 'REMARK',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '车型',
        name: 'MODEL',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '内部/外部',
        name: 'IN_OUT',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '产线',
        name: 'LINE',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '架位',
        name: 'SHELF',
        selectOnFocus: true,
        allowBlank: false
    }]
});