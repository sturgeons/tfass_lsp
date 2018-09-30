Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'}
    ],

    params : {
    	line: '',
    	op: '',
    	qadno: '',
    	shift: '',
    	check_type: '',
    	begin_date: Ext.util.Format.date( Ext.Date.add(new Date(), Ext.Date.DAY, -1), 'Y-m-d'),
    	end_date: Ext.util.Format.date(new Date(), 'Y-m-d')
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
                                       item.get("UNIT_NAME") && item.get("UNIT_NAME").indexOf(field.getValue()) > -1 ||
                                       item.get("QAD_NO") && item.get("QAD_NO").indexOf(field.getValue()) > -1; 
                            }
                        });
                    }
                }
            },
	    	'combobox[name=SHIFT_NAME]':{
	    		change: function(obj, val){
	    			 this.params.shift = val;
	    			 this.getGridPanel().getStore().removeFilter('shift_filter');
	    			 
	    			 if(val && val.length > 0){
		    			 	this.getGridPanel().getStore().filter({id: 'shift_filter', filterFn: function(item) { return  item.get("SHIFT") === val;}});
	    			 }
	            }
	        },
	    	'combobox[name=LINE]':{
	    		change: function(obj, val){
	    			 this.params.line = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });

	    			 Ext.getCmp('op_combo').setValue('');
	    			 Ext.getCmp('op_combo').getStore().load({params: this.params});
	            }
	        },
	    	'combobox[name=OP]':{
	    		change: function(obj, val){
	    			 this.params.op = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	            }
	        },
	    	'combobox[name=CHECK_TYPE]':{
	    		change: function(obj, val){
	    			 this.params.check_type = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	            }
	        },
	    	'datefield[name=BEGIN_DATE]':{
	    		change: function(obj, val){
	    			 this.params.begin_date = Ext.util.Format.date(val, 'Y-m-d');
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	            }
	        },
	    	'datefield[name=END_DATE]':{
	    		change: function(obj, val){
	    			 this.params.end_date = Ext.util.Format.date(val, 'Y-m-d');
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
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
	    
	    gridPanel.getStore().reload({
			 params: this.params
		 });
		
		Ext.getCmp('line_combo').getStore().load({
			 params: this.params
		 });
	}
});