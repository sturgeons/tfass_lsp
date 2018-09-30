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
        fieldLabel: '班次名',
        name: 'SHIFT_NAME',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '班次顺序',
        name: 'SHIFT_INDEX',
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }, {
        xtype: 'fieldcontainer',
        fieldLabel: '开始时间',
        labelWidth: 75,
        layout: 'hbox',
        items: [{
            xtype: 'numberfield',
            name: 'BEGIN_HOUR',
            hideLabel: true,
            width: 130,
            minValue: 0,
            maxValue: 23,
            editable: false,
            allowBlank: false
        }, {
            xtype: 'numberfield',
            name: 'BEGIN_MINUTE',
            hideLabel: true,
            width: 130,
            minValue: 0,
            maxValue: 59,
            editable: false,
            allowBlank: false
        }]}, {
            xtype: 'fieldcontainer',
            fieldLabel: '结束时间',
            labelWidth: 75,
            layout: 'hbox',
            items: [{
                xtype: 'numberfield',
                name: 'END_HOUR',
                hideLabel: true,
                width: 130,
                minValue: 0,
                maxValue: 23,
                editable: false,
                allowBlank: false
            }, {
                xtype: 'numberfield',
                name: 'END_MINUTE',
                hideLabel: true,
                width: 130,
                minValue: 0,
                maxValue: 59,
                editable: false,
                allowBlank: false
            }]}]
});