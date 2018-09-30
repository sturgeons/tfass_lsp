Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'},
       {ref: 'window', selector: 'windowcomponent'},
       {ref: 'formPanel', selector: 'formcomponent'},
       {ref: 'submitBtn', selector: 'button[action=submit]'}
    ],
    

    params : {
    	line: '',
    	op: '',
    	check_type: ''
    },
    
    init: function() {// Cotroller的业务处理
	    this.control({
	    	'textfield[name=searchField]': {
	            specialkey: function(field, e){
	                if (e.getKey() == e.ENTER) {
	                    var gridPanel = this.getGridPanel();
	                    gridPanel.getStore().filter({
	                        filterFn: function(item) {
	                            return !field.getValue() || 
	                                   item.get("CHECK_TYPE") && item.get("CHECK_TYPE").indexOf(field.getValue()) > -1; 
	                        }
	                    });
	                }
	            }
	        },
	    	'button[action=add]':{
	    		click: function(){
	    			var record =  Ext.getCmp('update').isDisabled() ? null : this.getGridPanel().getSelectionModel().getLastSelected();
	    			
	    			if(record) {
        				record = Ext.create('LDPlatformModule.model.Model', record.data);
	    			    record.data.QADNO = record.data.QADNO.toString().split(',');
        				delete record.data.ID;
        				record.data.UPDATED = new Date();
	                	this.getFormPanel().getForm().loadRecord(record);
	    			} else {
	    				this.getFormPanel().getForm().reset(true);
	    			}
	                this.getWindow().show().center();
	            }
	        },
	        'button[action=modify]': {
	        	click: function(){
	    			 var record = this.getGridPanel().getSelectionModel().getLastSelected();
	    			       record.data.QADNO = record.data.QADNO.toString().split(',');
	    			 
                	 this.getFormPanel().getForm().loadRecord(record);
                	 this.getWindow().show().center();
	            }
	        },
	        'button[action=del]': {
	        	click: function(){
	        	    var me= this, gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	        		  
	        		  Ext.MessageBox.confirm('确认删除', '你确定要删除选中记录吗?', function(res) {
		                    if (res === 'yes') { // 用户确认要执行删除操作
		                    	 Ext.Ajax.request({
			                            url: 'v1/MDqualityService/findById',
			                            params: {
			                            	id: gridPanel.getSelectionModel().getLastSelected().data.ID
			                            },
			                            method: 'POST',
			                            success: function(response, options) {
			                                var obj = Ext.decode(response.responseText);

			                                if (!obj.success) {
			                                	Ext.MessageBox.alert('删除失败', obj.failureReason);
			                                } else {
			                                	me.delRecord();
			                                }
			                            },
			                            failure: function(response, options) {
			                                Ext.MessageBox.alert('失败', '请求超时或网络故障, 错误编号');
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
	                	var qadno = '';
	                	
	        			if(record && record.data.ID) {// 编辑数据
	        				record.set(form.getValues());
	        			} else {// 新增数据
	        				record = Ext.create('LDPlatformModule.model.Model', me.getFormPanel().getForm().getValues());
	        				store.insert(0, record);
	        			}
	    			    record.data.EM_NO = Ext.getDom('em_id').value;
	        			
	        			Ext.each(record.data.QADNO, function(val) {
	        					qadno +=  (qadno.length > 0 ? "," : "") + val;
	        			});
	        			record.data.QADNO = qadno;
	                	
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
	        },
	    	'gridcomponent combobox[name=LINE]':{
	    		change: function(obj, val){
	    			 this.params.line = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	    			 Ext.getCmp('op_combo').getStore().load({
	    				 params: this.params
	    			 });
	    			 Ext.getCmp('op_combo').setValue('');
	            }
	        },
	        '#prod_line' :{
	    		change: function(obj, val){
	    			 this.params.line = val;
	    			 Ext.getCmp('qad_combom').setValue('');
	    			 Ext.getCmp('qad_combom').getStore().load({
	    				 params: this.params
	    			 });
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
	    	'combobox[name=FILE_TYPE]':{
	    		change: function(obj, val){
	    			 this.params.check_type = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	            }
	        },
	    	'combobox[name=ACTIVE]':{
	    		change: function(obj, val) {
	    			var active = val === '当前启用';
	    			this.getGridPanel().getStore().removeFilter('my_filter');
	    			this.getGridPanel().getStore().filter({
	    				id: 'my_filter', 
                        filterFn: function(item) {
                            return active ? item.get("ACTIVE") === '1' : item.get("ACTIVE") === '0'; 
                        }
                    });
	    			Ext.getCmp('add').setVisible(active);
	            }
	        },
	    	'radiogroup':{
	    		change: function(obj, val) {
	    			var form = this.getFormPanel();
	    			
	   				 var cmp_upper = form.down('numberfield[name=TOLERANCE_LIMIT_ON]');
					 var cmp_lower = form.down('numberfield[name=TOLERANCE_LIMIT_LOWER]');
					 var cmp_unit = form.down('combobox[name=MEASUREMENT_UNIT]');
					 var lower = form.down('combobox[name=LOWER_SIGN]');
					 var upper = form.down('combobox[name=UPPER_SIGN]');


	    			 // 如果用户选择的类型是逻辑判断，则不需要输入公差上下限、计量单位
					 Ext.each([cmp_upper, cmp_lower, cmp_unit, lower, upper], function(obj) {
						 obj.setDisabled(val.DATA_TYPE === 2);
						 
						 if(val.DATA_TYPE === 2) {// 只有在逻辑参数的时候，才能将这三个输入项设置为空
							  obj.setRawValue(null);

		                	  var record = form.getRecord();
	                	      record.data.TOLERANCE_LIMIT_ON = "";
	                	      record.data.TOLERANCE_LIMIT_LOWER = "";
	                	      record.data.MEASUREMENT_UNIT = "";
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
		Ext.create('LDPlatformModule.view.WindowComponent');
		
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	    
        // 装载数据
        store.load({
	    	params: this.params
	    }).on({
            "load": function(records) {
            	var active = Ext.getCmp('active').getValue() === '当前启用';
            	gridPanel.getStore().removeFilter('my_filter');
            	gridPanel.getStore().filter({
    				id: 'my_filter', 
                    filterFn: function(item) {
                        return active ? item.get("ACTIVE") === '1' : item.get("ACTIVE") === '0'; 
                    }
                });
            }, 
            "refresh": function() {
	            	gridPanel.getSelectionModel().deselectAll();
	            	gridPanel.getSelectionModel().select(0);
	            	
	            	Ext.getCmp('update').setDisabled(gridPanel.getStore().data.items.length === 0);
	            	Ext.getCmp('del').setDisabled(gridPanel.getStore().data.items.length === 0);
            }
        })
	},
	delRecord: function() {
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
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