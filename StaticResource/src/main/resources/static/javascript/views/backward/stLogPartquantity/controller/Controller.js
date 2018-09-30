Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'}
    ],
    
    init: function() {// Cotroller的业务处理
	    this.control({
	    	'textfield[name=searchField]': {
	            specialkey: function(field, e){
	                if (e.getKey() == e.ENTER) {
	                    var gridPanel = this.getGridPanel();
	                    gridPanel.getStore().filter({
	                        filterFn: function(item) {
	                            return !field.getValue() || 
	                                ( item.get("LINE") && item.get("LINE").indexOf(field.getValue()) > -1)|| 
	                                ( item.get("PARTNO") && item.get("PARTNO").indexOf(field.getValue()) > -1)|| 
	                                ( item.get("USERNAME") && item.get("USERNAME").indexOf(field.getValue()) > -1); 
	                        }
	                    });
	                }
	            }
	        },
	    	'button[action=clear]':{
	    		click: function(){
	    				this.getGridPanel().down('combobox').setValue(null);
	            }
	        },
	    	'gridcomponent combobox':{
	    		change: function(sel, val){
    				this.getGridPanel().getStore().load({
    					params: {LINE: val}
    				});
	            }
	        }
        })
    },
    
    /**
     * Module Launch
     */
	onLaunch: function() {
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	    
        // 装载数据
        store.load().on({
            "refresh": function(){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
            }
        })
	}
});