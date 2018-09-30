Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'}
    ],

    params : {
    	content: ''
    },
    init: function() {
	    this.control({
            'textfield[name=searchField]': {
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                        var gridPanel = this.getGridPanel();
                        gridPanel.getStore().filter({
                            filterFn: function(item) {
                                return !field.getValue() || 
                                       item.get("CONTENT") && item.get("CONTENT").indexOf(field.getValue()) > -1 ||
                                       item.get("QADNO") && item.get("QADNO").indexOf(field.getValue()) > -1; 
                            }
                        });
                    }
                }
            },
            'button[action=search]': {
            	click: function() {
                    var gridPanel = this.getGridPanel();
                    var inp = gridPanel.down('textfield[name=barcode]');
                    var val = inp.getValue();
                    
                    gridPanel.getStore().load({
                    	params: {
                    		content: val
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
	    
	    gridPanel.getStore().load({
			 params: this.params
		 }).on({
			 "load": function(){
				 gridPanel.down('textfield[name=barcode]').focus(true, 100);
			 }
		 });
	}
});