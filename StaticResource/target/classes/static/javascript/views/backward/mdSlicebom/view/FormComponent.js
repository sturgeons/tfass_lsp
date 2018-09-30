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
    },  {
        fieldLabel: '总成号',
        name: 'QADNO',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.QadStore'),
        displayField: 'QADNO',
        valueField: 'QADNO',
        allowBlank: false,
        editable: false
    },  {
    	id: 'fabric_no',
        fieldLabel: '布料号',
        name: 'FABRIC_NO',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.FabricStore'),
        queryModel: "local",
        triggerAction: 'all',   //点击下拉列表时执行的操作
        queryMode: 'local',    //store的查询模式
        displayField: 'FABRIC_NO',
        valueField: 'FABRIC_NO',
        allowBlank: false,
        editable: false
    },  {
        fieldLabel: '裁片号',
        name: 'CUT_NO',
        xtype: 'combobox',
        store: Ext.create('LDPlatformModule.store.CutStore'),
        displayField: 'CUT_NO',
        valueField: 'CUT_NO',
        allowBlank: false,
        editable: false
    }, {
        id: 'DEFAULT_INPUT',
        fieldLabel: 'BOM用量',
        name: 'BOM',
        minValue: 0,
        xtype: 'numberfield',
        selectOnFocus: true,
        allowBlank: false
    }]
});