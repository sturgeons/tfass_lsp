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
        fieldLabel: '零件号',
        name: 'PARTNO',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '架位',
        name: 'SHELF',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '包装量',
        name: 'PKG_CAPACITY',
        xtype: 'numberfield',
        minValue: 0,
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '体积',
        name: 'VOLUME',
        xtype: 'numberfield',
        minValue: 0,
        decimalPrecision: 3,
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '附带拉动',
        name: 'ATTACH',
        selectOnFocus: true
    },{
        fieldLabel: '备注',
        name: 'REMARK',
        selectOnFocus: true
    }]
});