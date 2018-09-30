Ext.define('LoginModule.view.Form' ,{
    extend: 'Ext.panel.Panel',
    alias: 'widget.loginform',
    
    layout: 'fit',
    items: [ {
    	xtype: 'form',
        split: false,
    	defaults: {
	    	xtype: 'textfield',
	        anchor: '100%'
	    },
	    items: [
	        {
	        	id: 'em_no',
	            name: 'em_no',
	            style: 'margin:20px 0 3px 0;',
	            enableKeyEvents: true,
	            selectOnFocus: true,
	            allowBlank: false
	        }
	    ],
	    buttons: [
	        {text: '重置', action: 'reset'}, 
	        {text: '登录', type: 'submit',action: 'login'}
	    ]
	 }]
});