Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'},
       {ref: 'itemGrid', selector: 'itemgrid'},
       {ref: 'qualityWindow', selector: 'qualitywindow'},
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
	                                   item.get("EM_NO") && item.get("EM_NO").indexOf(field.getValue()) > -1 || 
	                                   item.get("EM_NAME") && item.get("EM_NAME").indexOf(field.getValue()) > -1; 
	                        }
	                    });
	                }
	            }
	        },
	        'gridcomponent': {
	    		select: function(view, record, item, index){
	    			this.getItemGrid().getStore().load({
	    				params: {
	    					EM_ID: record.data.SYSID
	    				}
	    			});
    	        	Ext.getCmp('bind').setDisabled(record.data.EM_MONITOR === '0');
    	        	Ext.getCmp('unbind').setDisabled(true);
	    		}
	        },
	        'itemgrid': {
	    		select: function(view, record, item, index){
    	        	Ext.getCmp('unbind').setDisabled(false);
	    		},
	    		filterchange: function() {
	    			this.getPartPanel().getStore().removeAll();
	    		}
	    	},
	    	'button[action=bind]':{
	    		click: function(){
	    			// 获得窗体对象的引用
	            	var win = this.getQualityWindow();
	            	var emp_id = this.getGridPanel().getSelectionModel().getLastSelected().data.SYSID;
	            	
	            	Ext.getCmp('qualitygrid').getStore().load({
	            		params: { 
	            			EM_ID: emp_id
	            		}
	            	}).on('load', function(){
	            		Ext.getCmp('qualitygrid').getSelectionModel().deselectAll();
	            	});
	                win.show(); // 显示窗体
	                win.center();// 窗体居中显示
	            }
	        },
	        'button[action=unbind]': {
	        	click: function(){
	        	    var gridPanel = this.getItemGrid(), store = gridPanel.getStore();
	        		  
	        		  Ext.MessageBox.confirm('确认删除', '确定要解除模板的绑定吗?', function(res) {
		                    if (res === 'yes') { // 用户确认要执行删除操作
		                         store.remove(gridPanel.getSelectionModel().getLastSelected());
		                         store.sync({
		 	                		success: function() {
		 	                			gridPanel.getStore().reload();
			                		},
		 	                		failure: function() {
		                                Ext.MessageBox.alert('执行失败', '详细信息请查看运行日志!');
		                                store.rejectChanges();
			                		}
			                	});
		                    }
		              });
	            }
	        },
	    	'button[action=add]':{
	    		click: function(){
	                this.getFormPanel().getForm().reset(true);
	                this.getWindow().show().center();
	            }
	        },
	        'button[action=modify]': {
	        	click: function(){
                	 this.getFormPanel().getForm().loadRecord(this.getGridPanel().getSelectionModel().getLastSelected());
                	 this.getWindow().show().center();
	            }
	        },
	        'button[action=del]': {
	        	click: function(){
	        	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	        		  
	        		  Ext.MessageBox.confirm('确认删除', '你确定要删除选中记录吗?', function(res) {
		                    if (res === 'yes') { // 用户确认要执行删除操作
		                         store.remove(gridPanel.getSelectionModel().getLastSelected());
		                         store.sync({
		 	                		success: function() {
		 	                			gridPanel.getStore().reload();
			                		},
		 	                		failure: function() {
		                                Ext.MessageBox.alert('执行失败', '详细信息请查看运行日志!');
		                                store.rejectChanges();
			                		}
			                	});
		                    }
		              });
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
	        			} else {// 新增数据
	        				record = Ext.create('LDPlatformModule.model.Model', me.getFormPanel().getForm().getValues());
		                	record.data.SYSID = Ext.create('Ext.ux.UUIDGenerator').generate();
	        				store.insert(0, record);
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
	        'button[action=commitQuality]': {
	        	click: function(){
	               var window = this.getQualityWindow();
	               var gridPanel = this.getItemGrid();
	        	   var em_id = this.getGridPanel().getSelectionModel().getLastSelected().data.SYSID;
	               var arr = [];
	               Ext.each(Ext.getCmp('qualitygrid').getSelectionModel().getSelection(), function(record){
	            	   record.data.EM_ID = em_id;
	            	   arr.push(record.data);
	               });
	               
	               Ext.Ajax.request({
                       url: 'v1/MDemqualityService/add',
                       params: {parts: JSON.stringify(arr) },
                       method: 'POST',
                       success: function(response, options) {
                    	   gridPanel.getStore().reload();
                       },
                       failure: function(form, action) { // 添加失败后，提示用户添加异常
                       	try{
                       		Ext.Msg.alert('失败', '操作未完成，原因：' + action.result.failureReason);
                       	} catch(e){
                       		Ext.Msg.alert('失败', '操作未完成，原因：程序错误，请查看运行日志.');
                       	}
                       }
                   });
                   // 关闭当前弹出窗
                   setTimeout(function() {window.hide();}, 100);
	            }
	        },
	        'button[action=cancelQuality]': {
	        	click: function(){
	        		this.getQualityWindow().hide();
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
		Ext.create('LDPlatformModule.view.QualityWindow');
		
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	    
        // 装载数据
        store.load().on({
            "load": function(obj, records){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
	        	Ext.getCmp('unbind').setDisabled(true);
	        	
	        	gridPanel.down('button[action=modify]').setDisabled(!records.length);
	        	gridPanel.down('button[action=del]').setDisabled(!records.length);
            },
            "refresh": function() {
	        	gridPanel.down('button[action=modify]').setDisabled(!store.data.items.length);
	        	gridPanel.down('button[action=del]').setDisabled(!store.data.items.length);
            }
        });
	}
});