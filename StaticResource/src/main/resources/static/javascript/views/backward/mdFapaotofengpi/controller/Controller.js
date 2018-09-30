Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'},
       {ref: 'window', selector: 'windowcomponent'},
       {ref: 'formPanel', selector: 'formcomponent'},
       {ref: 'submitBtn', selector: 'button[action=submit]'}
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
	                                   item.get("QADNO") && item.get("QADNO").indexOf(field.getValue()) > -1; 
	                        }
	                    });
	                }
	            }
	        },
	        'button[action=modify]': {
	        	click: function(){
                	 this.getFormPanel().getForm().loadRecord(this.getGridPanel().getSelectionModel().getLastSelected());
                	 this.getWindow().show().center();
	            }
	        },
	        'button[action=submit]': {
	        	click: function(){
	                var me = this, store = this.getGridPanel().getStore(), form = this.getFormPanel().getForm();
	                
	                // 检查表单项的录入是否存在问题
	                if (form.isValid()) {
	                	var record = form.getRecord();
	                	
	        			if(record) {// 编辑数据
	        				record.set(form.getValues());
	        			}
	                	
	                	store.sync({
	                		success: function() {
	                			me.getGridPanel().getStore().reload();
	                		},
	                		failure: function() {
                                Ext.MessageBox.alert('执行失败', '数据重复或网络错误!');
                                store.rejectChanges();
	                		}
	                	});
	                    setTimeout(function() { me.getWindow().hide();}, 100);
	                }
	        	}
	        },
	        'button[action=cancel]': {
	        	click: function(){
	        		this.getWindow().hide();
	        	}
	        },
	        'windowcomponent': {
	        	show: function(){
    	            Ext.getCmp('DEFAULT_INPUT').focus(true, 100);
	        	}
	        }
        })
    },
    
    /**
     * Module Launch
     */
	onLaunch: function() {
		Ext.create('LDPlatformModule.view.WindowComponent');
		
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	    
        // 装载数据
        store.load().on({
            "refresh": function(){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
            },
            "load": function() {
            		Ext.getCmp('update_btn').setDisabled(store.data.items.length === 0);
           }
        })
	}
});