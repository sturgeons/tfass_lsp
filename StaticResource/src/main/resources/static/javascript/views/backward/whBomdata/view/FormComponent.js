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
        fieldLabel: '骨架',
        name: 'SKELETON',
        selectOnFocus: true,
        allowBlank: false
    }, {
        fieldLabel: '发泡总成',
        name: 'FAPAO_QADNO',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '缝皮总成',
        name: 'FENGPI_QADNO',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '缝皮车型',
        name: 'FENGPI_MODEL',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '缝皮总成描述',
        name: 'FENGPI_DESC',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '装配总成',
        name: 'ZHUANGPEI_QADNO',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '总成车型',
        name: 'QAD_MODEL',
        selectOnFocus: true,
        allowBlank: true
    }, {
        fieldLabel: '总成描述',
        name: 'QAD_DESC',
        selectOnFocus: true,
        allowBlank: true
    }]
});