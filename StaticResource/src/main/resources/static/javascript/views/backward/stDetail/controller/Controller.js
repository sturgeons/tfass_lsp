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
                                       item.get("QAD_TYPE") && item.get("QAD_TYPE").indexOf(field.getValue()) > -1 ||
                                       item.get("QAD_NO") && item.get("QAD_NO").indexOf(field.getValue()) > -1; 
                            }
                        });
                    }
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
        store.load().on({
            "refresh": function(){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
            }
        })
	}
});