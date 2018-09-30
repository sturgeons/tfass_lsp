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
        name: 'QADNO',
        hidden: true,
        hideLabel: true
    }, {
        id: 'DEFAULT_INPUT',
        fieldLabel: '合格待入库',
        name: 'OK_COUNT',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true
    }, {
        fieldLabel: '待返修',
        name: 'REWORK_COUNT',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true
    }]
});