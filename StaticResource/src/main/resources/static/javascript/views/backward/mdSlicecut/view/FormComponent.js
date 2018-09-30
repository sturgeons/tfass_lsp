Ext.define('LDPlatformModule.view.FormComponent', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formcomponent',
	
    border: false, // 不显示边线
    defaults: { // 组件的默认样式配置
    	xtype: 'textfield',
        labelWidth: 65, // label的默认宽度
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
        fieldLabel: '裁片号',
        name: 'CUT_NO',
        selectOnFocus: true,
        allowBlank: false
    },  {
        fieldLabel: '模板号',
        name: 'PROG_NO',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.ProgStore'),
        displayField: 'PROG_NO',
        valueField: 'PROG_NO',
        allowBlank: true,
        editable: false
    }, {
        xtype: 'checkbox',
        fieldLabel: '先进先出',
        name: 'FIFO',
        inputValue: '1',
        uncheckedValue: '0'
    }, {
        fieldLabel: '库存量',
        name: 'CUT_COUNT',
        minValue: 0,
        value: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '备注',
        name: 'REMARK',
        selectOnFocus: true,
        allowBlank: true
    }]
});