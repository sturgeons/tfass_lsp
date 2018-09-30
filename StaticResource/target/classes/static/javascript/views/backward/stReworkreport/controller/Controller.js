Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'}
    ],
    
    init: function() {
	    this.control({
            'textfield[name=searchField]': {
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                        var gridPanel = this.getGridPanel();
                        gridPanel.getStore().filter({
                            filterFn: function(item) {
                                return !field.getValue() || 
                                       item.get("QADNO") && item.get("QADNO").indexOf(field.getValue()) > -1; 
                            }
                        });
                    }
                }
            },
	    	'button[action=search]':{
	    		click: function(){
	    			this.getGridPanel().getStore().reload({
	    				 params: {
	    					  begin_date:  Ext.util.Format.date(Ext.getCmp('begin_date').getValue(), 'Y-m-d H:i'),
	    					  end_date: Ext.util.Format.date(Ext.getCmp('end_date').getValue(), 'Y-m-d H:i'),
	    					  state: Ext.getCmp('state').getValue(),
	    					  teamno: Ext.getCmp('teamno').getValue()
	    				 }
	    			 });
	            }
	        }
	    })
    },
    
    /**
     * Module Launch
     */
	onLaunch: function() {
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore(), me = this;
	    
        // 装载数据
        store.load({
			 params: {
				  begin_date:  Ext.util.Format.date(Ext.getCmp('begin_date').getValue(), 'Y-m-d H:i'),
				  end_date: Ext.util.Format.date(Ext.getCmp('end_date').getValue(), 'Y-m-d H:i'),
				  state: Ext.getCmp('state').getValue(),
				  teamno: Ext.getCmp('teamno').getValue()
			 }
		 }).on({
            "refresh": function(){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
            }
        })
	}
});