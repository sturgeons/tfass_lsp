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
        name: 'PLAN_DATE',
        hidden: true,
        hideLabel: true
    }, {
        fieldLabel: '零件类型',
        name: 'CUST_PARTNO',
        readOnly: true
    }, {
        fieldLabel: '总成号',
        name: 'QADNO',
        readOnly: true
    }, {
        id: 'DEFAULT_INPUT',
        fieldLabel: '计划数量',
        name: 'PLAN_COUNT',
        xtype: 'numberfield',
        minValue: 0,
        selectOnFocus: true,
        allowBlank: false
    }]
});