Ext.define('MainModule.controller.TreePanelController', {
    extend: 'Ext.app.Controller',
    refs: [
        {ref: 'userPanel', selector: 'userpanel'},
        {ref: 'gridPanel', selector: 'gridpanel'},
        {ref: 'window', selector: 'windowcomponent'},
        {ref: 'formPanel', selector: 'formcomponent'}
    ],
    
    params : {
    	em_id: Ext.getDom('em_id').value,
    	line: '',
    	op: '',
    	qadno: '',
    	check_type: '',
    	shift: '',
    	date: Ext.util.Format.date(new Date(), 'Y-m-d')
    },
    
    init: function() {// Cotroller的业务处理
	    this.control({
	        'button[action=exitSystem]': {
	        	click: function(){
                	 window.location.href = "/technics";
	            }
	        },
	        '#dataGrid': {
	        	celldblclick: function(){
	        		var record = this.getGridPanel().getSelectionModel().getLastSelected();
                	this.getFormPanel().getForm().loadRecord(record);

	    			if(record.data.DATA_TYPE === 1) {
	    				$('#keyboard').val(record.data.RESULT_VAL);
		    			$('#keyboard').keyboard({
		    				layout: 'custom',
		    				customLayout: {
		    					'normal' : [
		    						'1 2 3 4 5 6 7 8 9 0 . {bksp} {a} {c}'
		    					]
		    				},
		    				display: {
		    					'bksp'   :  '退格',
		    					'a' : '确认',
		    					'c' : '取消'
		    				},
		    				stayOpen: true,
		    				accepted: function() {
		    					Ext.getCmp('DEFAULT_INPUT').setValue($('#keyboard').val());
		    					Ext.getCmp('submitBtn').fireEvent('click');
		    				}
		    			}).getkeyboard().reveal();
	    			} else {
	    				  Ext.Msg.show({
	    					    title: '<span style="font-size:12pt;">确认状态</span>',
	    					    msg: '<p style="font-size:24pt;margin-top:18px;">检验信息是否合格?</p>',
	    					    width: 350,
	    					    height:200,
	    					    cls: 'fx-chk-confirm',
	    					    buttons: Ext.Msg.YESNOCANCEL,
	    					    fn: function(res) {
					                    if (res === 'yes') { // 用户确认要执行删除操作
					    					Ext.getCmp('DEFAULT_INPUT').setValue("合格");
					                    } else if (res === 'no'){
					                    	Ext.getCmp('DEFAULT_INPUT').setValue("不合格");
					                    } else {
					                    	return;
					                    }
				    					Ext.getCmp('submitBtn').fireEvent('click');
				                }
	    			     });
	    			}
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
	                }

	                this.getGridPanel().down('button[action=reset]').setDisabled(false);
	                this.getGridPanel().down('button[action=commit]').setDisabled(false);
	        	}
	        },
	        
	        'button[action=commit]': {
	        	click: function() {
	                var me = this, store = this.getGridPanel().getStore(), datas = [], isNotNull = true;
	                
	                Ext.each(store.data.items, function(rec) {
	                		isNotNull = rec.get("RESULT_VAL").length > 0 & isNotNull;

	                		rec.data.EM_ID = Ext.getDom('em_id').value;
	                		rec.data.SHIFT_NAME = Ext.getCmp('shift').getValue();
	                		rec.data.CREATED = me.params.date;
		                	datas.push(rec.data);
	                });
	                
	                if(!isNotNull) {
              			me.showMsg('提交失败', '检查项填写不完整，存在漏填项目.');
	                } else {
		                me.postChange(datas);
	                }
	        	}
	        },
	        'button[action=reset]': {
	        	click: function(){
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	        	}
	        },
	    	'datefield':{
	    		change: function(obj, val){
	    			 this.params.date = Ext.util.Format.date(val, 'Y-m-d');
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	            }
	        },
	    	'combobox[name=LINE]':{
	    		change: function(obj, val){
	    			 this.params.line = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	    			 
	    			 Ext.getCmp('qadno_combo').getStore().reload({
	    				 params: {
	    					 line: val
	    				 }
	    			 }).on({"load": function() {
		    			    Ext.getCmp('qadno_combo').setValue("");
	    			 }});

	    			 Ext.getCmp('op_combo').getStore().reload({
	    				 params: {
	    					 line: val
	    				 }
	    			 }).on({"load": function() {
		    			    Ext.getCmp('op_combo').setValue("");
	    			 }});
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
	    	'combobox[name=QADNO]':{
	    		change: function(obj, val){
	    			 this.params.qadno = val;
	    			 this.getGridPanel().getStore().reload({
	    				 params: this.params
	    			 });
	    			 
    			    Ext.getCmp('op_combo').setValue("");
	            }
	        },
	    	'combobox[name=SHIFT_NAME]':{
	    		change: function(obj, val){
	    			 this.params.shift = val;
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
		Ext.create('MainModule.view.WindowComponent');
		var panel = this.getGridPanel();
		
		panel.getStore().on('load', function(){
				panel.down('button[action=reset]').setDisabled(true);
				panel.down('button[action=commit]').setDisabled(true);
		});
		
        // 页面加载完成后去除等待窗体
	    Ext.getCmp('line_combo').getStore().load({
			 params: this.params
		 }).on({"load": function() {
				 if (Ext.get('loading')) {
			            setTimeout(function() {
			                Ext.get('loading').remove();
			                Ext.get('loading-mask').fadeOut({remove: true});
			            }, 1 * 1000);
			    }
		 }});
	},
	postChange: function(datas) {
		var me = this;
		Ext.Ajax.request({
              url: 'v1/QAdataService/update',
              params: {datas: JSON.stringify(datas) },
              method: 'POST',
              success: function(response, options) {// 生成回馈对象
                  var obj = Ext.decode(response.responseText);
                  
                  if (obj.success) {// 数据正确提交后，返回登录页面
                	 window.location.href = "/technics";
                  } else {
                      this.showMsg('失败', obj.failureReason);
                  }
              },
              failure: function(form, action) { // 添加失败后，提示用户添加异常
                  	try{
                            this.showMsg('失败', obj.failureReason);
                  	} catch(e){
                  			this.showMsg('失败', '操作未完成，原因：程序错误，请查看运行日志.');
                  	}
              }
          });
	},
	showMsg: function(title, msg) {
		  Ext.Msg.show({
			    title: title,
			    msg: '<p style="font-size:24pt;margin-top:18px;">' + msg + '</p>',
			    cls: 'fx-chk-confirm',
			    buttons: Ext.Msg.OK
	     });
	}
});