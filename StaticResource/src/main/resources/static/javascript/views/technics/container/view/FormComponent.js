Ext.define('MainModule.view.FormComponent', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formcomponent',
	
	id: 'formPanel',
    border: false, // 不显示边线
    defaults: { // 组件的默认样式配置
    	xtype: 'textfield',
        anchor: '100%'
    },
    items: [{
        fieldLabel: '主键',
        name: 'SYSID',
        hidden: true,
        hideLabel: true
    }, {
        fieldLabel: '主键',
        name: 'ID',
        hidden: true,
        hideLabel: true
    }, {
        id: 'DEFAULT_INPUT',
        xtype: 'textarea',
        rows: 10,
        name: 'RESULT_VAL',
        selectOnFocus: true
    }, {
        name: 'SHIFT_NAME'
    }]
});