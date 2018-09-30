Ext.define('MainModule.controller.TreePanelController', {
    extend: 'Ext.app.Controller',
    refs: [
        {ref: 'userPanel', selector: 'userpanel'},
        {ref: 'gridPanel', selector: 'gridpanel'},
        {ref: 'resultGrid', selector: 'resultgridpanel'}
    ],
    
    params : {
    	em_id: Ext.getDom('em_id').value,
    	line: '',
    	op: '',
    	qadno: '',
    	shift: '',
    	date: ''
    },
    
    init: function() {// Cotroller的业务处理
	    this.control({
	        'button[action=exitSystem]': {
	        	click: function(){
                	 window.location.href = "/technics";
	            }
	        }, 
	        'button[action=clear]': {
	        	click: function(){
	        		 Ext.getCmp('date_field').setValue('');
	            }
	        },
	        'button[action=remove]' : {
	        	click: function() {
	        		 var me = this;
                	 Ext.MessageBox.confirm('确认删除', '确定要删除当前的质量数据吗?', function(res) {
		                     if (res === 'yes'){
					        	    var panel = me.getGridPanel().getStore();
			    	        		var items = panel.data.items;
			    	        		var ids = [];
			    	        		
			    	        		for(var i = 0; i < items.length; i++) {
				  		        		  ids.push( items[i].data.SYSID);
			    	        		}
			    	        		me.remove(ids);
		                    }
		              });
	        	}
	        },
	        'button[action=confirm]' : {
	        	click: function() {
		        	    var me = this;
		        	    var panel = me.getGridPanel();
    	        		var store = panel.getStore();
    	        		var ids = [];
    	        		var allRight = true;
    	        		
    	        		Ext.getCmp('date_field').setValue(null);
    	        		Ext.getCmp('shift').setValue(null);
    	        		Ext.getCmp('data_filter').setValue(null);
    	        		
    	        		store.clearFilter();
    	        		store.filter({ filterFn: function(item) { return  me.params.line.length === 0 || item.get("LINE") === me.params.line;}});
    	        		
    	        		var items = store.data.items;
    	        		for(var i = 0; i < items.length; i++) {
    	        			  var rec = items[i];
    	        			  var value =  rec.get("RESULT_VAL");
	  						  var base = rec.get('VAL').match(/[\d.-]+/);// 取值范围
	  		        		  var datas = base.toString().split('-');
	  		        		  
	  		        		  if(value.length === 0) { return Ext.MessageBox.alert('提交失败', '当前生产线存在漏填的检测数据，无法进行提交.'); }
	  		        		  
	  		        		  if(rec.get('DATA_TYPE') === 2) {
	  		        			  	allRight  =  allRight & value === '合格';
	  		        		  } else {
	  		        			    var low = rec.get('TOLERANCE_LIMIT_LOWER');
			  		  		      	var upper = rec.get('TOLERANCE_LIMIT_ON');
				  			      	var res = true;
				  			      	
				  			      	if(low.toString().length > 0) {
				  			      		res =  res & eval(low + " "+ rec.get('LOWER_SIGN') + value);
				  			      	}
				  			      	if(upper.toString().length > 0) {
				  			      		res = res & eval(value + rec.get('UPPER_SIGN') + " " + upper);
				  			      	}
			  			      	
		  		        		    allRight =  allRight & res;
	  		        		  }
	  		        		  ids.push(rec.data.SYSID);
    	        		}
    	        		
    	        		
    	        		if(!allRight) {
	   	                	 Ext.MessageBox.confirm('确认提交', '存在异常数据，检测值不符合要求，确定要提交吗?', function(res) {
	   			                     if (res === 'yes'){
	   			                    	 me.postChange(ids);
	   			                    }
	   			              });
	   	                } else {
	   		                me.postChange(ids);
	   	                }
	        	}
	        },
	    	'datefield':{
	    		change: function(obj, val){
	    			 this.params.date = Ext.util.Format.date(val, 'Y-m-d');
	    			 if(Ext.getCmp('data_filter').isVisible()) {
		    			 this.getGridPanel().getStore().reload({
		    				 params: this.params
		    			 });
	    			 } else {
		    			 this.getResultGrid().getStore().reload({
		    				 params: this.params
		    			 });
	    			 }
	            }
	        },
	    	'combobox[name=LINE]':{
	    		change: function(obj, val){
	    			 this.params.line = val;

	    			 if(Ext.getCmp('data_filter').isVisible()) {
			    			 this.getGridPanel().getStore().reload({
			    				 params: this.params
			    			 });
	    				 
		  	        		Ext.getCmp('date_field').setValue(null);
		  	        		Ext.getCmp('shift').setValue(null);
		  	        		Ext.getCmp('data_filter').setValue(null);
		  	        		
		 	        		Ext.getCmp('date_field').setDisabled(!val);
		 	        		Ext.getCmp('shift').setDisabled(!val);
	    			 } else {
			    			 this.getResultGrid().getStore().reload({
			    				 params: this.params
			    			 });
			  	        	Ext.getCmp('complete_filter').setValue(null);
	    			 }
 	        		Ext.getCmp('data_filter').setDisabled(!val);
 	        		Ext.getCmp('complete_filter').setDisabled(!val);
	            }
	        },
	    	'combobox[name=SHIFT_NAME]':{
	    		change: function(obj, val){
	    			 this.params.shift = val;
	    			 this.getGridPanel().getStore().removeFilter('shift_filter');
	    			 this.getResultGrid().getStore().removeFilter('shift_filter');
	    			 
	    			 if(val && val.length > 0){
		    			 this.getGridPanel().getStore().filter({id: 'shift_filter', filterFn: function(item) { return  item.get("SHIFT") === val;}});
		    			 this.getResultGrid().getStore().filter({id: 'shift_filter',  filterFn: function(item) { return  item.get("SHIFT") === val;}});
	    			 }
	            }
	        },
	    	'combobox[name=DATA_FILTER]':{
	    		change: function(obj, val) {
	    			var gridPanel = this.getGridPanel();
	    			
	    			// 清楚无效的过滤器
	    			gridPanel.getStore().removeFilter('data_filter'); 
	    			
	    			// 查询逻辑判断合格的
	    			if(val === '已填合格') {
		    			  gridPanel.getStore().filter({id: 'data_filter', filterFn: function(item) {  
	    					  var value =  item.get("RESULT_VAL");
	    					  var low = item.get('TOLERANCE_LIMIT_LOWER');
		  		  		      var upper = item.get('TOLERANCE_LIMIT_ON');
			  			      var res = true;
			  			      
		    				  if(item.get('DATA_TYPE') === 2) {
  		        			  		return  value === '合格';
  		        		      }
		    				  
		    				  if(value.toString().length === 0){
		    					  return false;
		    				  } 
  		        		  
  		        		     if(low.toString().length > 0) {
			  			      		res =  res & eval(low + " "+ item.get('LOWER_SIGN') + value);
			  			      }
  		        		  
			  			      if(upper.toString().length > 0) {
			  			      		res = res & eval(value + item.get('UPPER_SIGN') + " " + upper);
			  			      }
	    					  return res;
		    			  }});
	    			}
	    			// 查询已填未合格的
	    			else if(val === '已填未合格') {
		    			  gridPanel.getStore().filter({
		    				  id: 'data_filter',
		    				  filterFn: function(item) { 
		    					  var value =  item.get("RESULT_VAL");
		    					  var low = item.get('TOLERANCE_LIMIT_LOWER');
			  		  		      var upper = item.get('TOLERANCE_LIMIT_ON');
				  			      	
	    		        		  if(item.get('DATA_TYPE') === 2) {
	    		        			  	return  value === '不合格';
	    		        		  }
	    		        		  //  有任意条件存在问题，都算是错误数据
		    					  return (
		    							  value.toString().length > 0 && (
			    							  (low.toString().length > 0 && !eval(low + " "+ item.get('LOWER_SIGN') + value)) 
			    							  ||
			    							  (upper.toString().length > 0 && !eval(value + item.get('UPPER_SIGN') + " " + upper))
		    							  )
		    					  );
		    			      }
		    			  });
	    			} else if(val === '漏填') {
		    			  gridPanel.getStore().filter({id: 'data_filter', filterFn: function(item) { return  item.get("RESULT_VAL") === '';}});
	    			}
	            }
	        },
	    	'combobox[name=COMPLETE_FILTER]':{
	    		change: function(obj, val) {
	    			var gridPanel = this.getResultGrid();
	    			
	    			// 清楚无效的过滤器
	    			gridPanel.getStore().removeFilter('data_filter'); 
	    			
	    			// 查询逻辑判断合格的
	    			if(val === '已填合格') {
		    			  gridPanel.getStore().filter({id: 'data_filter', filterFn: function(item) {  
	    					  var value =  item.get("RESULT_VAL");
	    					  var low = item.get('TOLERANCE_LIMIT_LOWER');
		  		  		      var upper = item.get('TOLERANCE_LIMIT_ON');
			  			      var res = true;
			  			      
		    				  if(item.get('DATA_TYPE') === 2) {
  		        			  		return  value === '合格';
  		        		      }
		    				  
		    				  if(value.toString().length === 0){
		    					  return false;
		    				  } 
  		        		  
  		        		      if(low.toString().length > 0) {
			  			      		res =  res & eval(low + " "+ item.get('LOWER_SIGN') + value);
			  			      }
  		        		  
			  			      if(upper.toString().length > 0) {
			  			      		res = res & eval(value + item.get('UPPER_SIGN') + " " + upper);
			  			      }
	    					  return res;
		    			  }});
	    			}
	    			// 查询已填未合格的
	    			else if(val === '已填未合格') {
		    			  gridPanel.getStore().filter({
		    				  id: 'data_filter',
		    				  filterFn: function(item) { 
		    					  var value =  item.get("RESULT_VAL");
		    					  var low = item.get('TOLERANCE_LIMIT_LOWER');
			  		  		      var upper = item.get('TOLERANCE_LIMIT_ON');
				  			      	
	    		        		  if(item.get('DATA_TYPE') === 2) {
	    		        			  	return  value === '不合格';
	    		        		  }
	    		        		  //  有任意条件存在问题，都算是错误数据
		    					  return (
		    							  value.toString().length > 0 && (
			    							  (low.toString().length > 0 && !eval(low + " "+ item.get('LOWER_SIGN') + value)) 
			    							  ||
			    							  (upper.toString().length > 0 && !eval(value + item.get('UPPER_SIGN') + " " + upper))
		    							  )
		    					  );
		    			      }
		    			  });
	    			}
	    			return true;
	            }
	        }
        })
    },
    /**
     * Module Launch
     */
	onLaunch: function() {
		this.getGridPanel().getStore().reload({
			 params: this.params
		 }).on({"load": function(store, records) {
				 if (Ext.get('loading')) {
			            setTimeout(function() {
			                Ext.get('loading').remove();
			                Ext.get('loading-mask').fadeOut({remove: true});
			            }, 1 * 1000);
			    }
		 }, 
		 "refresh": function(view){
				Ext.getCmp('commit_btn').setDisabled(view.data.items.length === 0);
				Ext.getCmp('remove_btn').setDisabled(view.data.items.length === 0);
		 }});
		
		 Ext.getCmp('line_combo').getStore().load({
			 params: this.params
		 });
	},
	postChange: function(ids) {
			var me = this;
		
			Ext.Ajax.request({
		            url: 'v1/QAmonitorService/update',
		            params: { ids: JSON.stringify(ids) },
		            method: 'POST',
		            success: function(response, options) {
		                // 生成回馈对象
		                var obj = Ext.decode(response.responseText);
		
		                // 根据不同的删除状态，做不同的提示
		                if (obj.success) {
		                		me.getGridPanel().getStore().reload();
		                } else {
		                    	Ext.MessageBox.alert('失败', '提交失败, 原因：' + obj.failureReason);
		                }
		            },
		            failure: function(response, options) {
		                	Ext.MessageBox.alert('失败', '请求超时或网络故障, 错误编号：' + response.status);
		            }
	        });
	},
	remove: function(ids) {
		var me = this;
	
		Ext.Ajax.request({
	            url: 'v1/QAmonitorService/del',
	            params: { ids: JSON.stringify(ids) },
	            method: 'POST',
	            success: function(response, options) {
	                // 生成回馈对象
	                var obj = Ext.decode(response.responseText);
	
	                // 根据不同的删除状态，做不同的提示
	                if (obj.success) {
	                		me.getGridPanel().getStore().reload();
	                } else {
	                    	Ext.MessageBox.alert('失败', '提交失败, 原因：' + obj.failureReason);
	                }
	            },
	            failure: function(response, options) {
	                	Ext.MessageBox.alert('失败', '请求超时或网络故障, 错误编号：' + response.status);
	            }
        });
}
});