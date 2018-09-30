Ext.define('SystemUserModule.controller.SystemUserController', {
    extend: 'Ext.app.Controller',
    refs: [
       {ref: 'gridPanel', selector: 'systemusergrid'},
       {ref: 'window', selector: 'systemuserwindow'},
       {ref: 'formPanel', selector: 'systemuserform'},
       {ref: 'tabPanel', selector: 'systemusertabpanel'},
       {ref: 'itemSelector', selector: '#itemselector-field'}
    ],
    
    // Cotroller的业务处理
    init: function() {
	    this.control({
            'textfield[name=searchField]': {
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                        var gridPanel = this.getGridPanel();
                        gridPanel.getStore().filter({
                            filterFn: function(item) {
                                return !field.getValue() || 
                                       item.get("username") && item.get("username").indexOf(field.getValue()) > -1; 
                            }
                        });
                    }
                }
            },
	    	'textfield[name=password]':{
	    		keyup: function(field){
	    			Ext.getCmp('hidepass').setValue(hex_md5(field.getValue()));
	    		}
	    	},
	    	'systemusergrid button[action=add]':{
	    		click: function(){
	    			// 获得窗体对象的引用
	            	var systemUserWindow = this.getWindow();
	            	// 在执行新增业务的时候，要把窗体的内容清空
	                this.getFormPanel().getForm().reset();
	                this.getItemSelector().getStore().load();
	                systemUserWindow.show(); // 显示窗体
	                systemUserWindow.center();// 窗体居中显示
	            }
	        },
	        'systemusergrid button[action=modify]': {
	        	click: function(){
	                // 获得grid的SelectionModel
	                var sm = this.getGridPanel().getSelectionModel();
	                // 当前选中记录
	                var record = sm.getLastSelected();

	                // 只有存在选中行的时候才显示修改窗口
	                if (record) {
		    			// 获得窗体对象的引用
		            	var systemUserWindow = this.getWindow();
		            	// 判断窗体对象是否存在, 如果不存在，就创建一个新的窗体对象
		            	if(!systemUserWindow){systemUserWindow = Ext.create('SystemUserModule.view.SystemUserWindow');}
		            	
	                	// 窗体对象
	                    this.getFormPanel().getForm().loadRecord(record); // 加载要编辑的对象
	                    this.getItemSelector().getStore().load({params: {userId: record.get('id')}});
		                systemUserWindow.show(); // 显示窗体
	                    systemUserWindow.center();
	                }
	            }
	        },
	        'systemusergrid button[action=del]': {
	        	click: function(){
	            	// 表格对象
	                var gridObj = this.getGridPanel();
	                var sm = gridObj.getSelectionModel();
	                
	                // 如果选中行无效，则不相应用户的删除操作
	                if (sm.getSelection().length < 1) {
	                    return false;
	                }

	                Ext.MessageBox.confirm('确认删除', '你确定要删除选中记录吗?', function(res) {
	                    if (res === 'yes') { // 用户确认要执行删除操作
	                        Ext.Ajax.request({
	                            url: 'services/delSystemUser',
	                            params: {
	                            	sysid: sm.getLastSelected().get('sysid')
	                            },
	                            method: 'POST',
	                            success: function(response, options) {
                                    gridObj.getStore().reload();
	                            },
	                            failure: function(response, action) {
	                                Ext.MessageBox.alert('失败', '操作失败：' + action.result.failureReason);
	                            }
	                        });
	                    }
	                });
	            }
	        },
	        'systemuserwindow': {
	    		show: function(){
	    			this.getTabPanel().setActiveTab(0);
	    			Ext.getCmp('username').focus(100, true);
	    		}
	    	},
	    	'systemuserwindow button[action=submit]': {
	    		click: function() {
	                // form表单对象 
	                var formObj = this.getFormPanel().getForm();
	                var gridPanel = this.getGridPanel();
	                var window = this.getWindow();
	                var hidepass = Ext.getCmp('hidepass');
	                var password= Ext.getCmp('password');
	                
	                // 检查表单项的录入是否存在问题
	                if (formObj.isValid()) {
	                	// 用户组ID
	                	Ext.getCmp("groupid").setValue(this.getItemSelector().getValue());
	                	
	                    // 用户密码
	                    if(hidepass.getValue()) { password.setValue(hidepass.getValue()); }
	                	
	                    // 提交表单
	                    formObj.submit({
	                        waitMsg: '数据正在处理请稍后', // 提示信息  
	                        waitTitle: '提示', // 标题  
	                        url: 'services/systemUserModify', // 请求的url地址  
	                        method: 'POST', // 请求方式  
	                        success: function(form, action) { // 添加数据成功后，重新加载数据源刷新表单 
	                        	gridPanel.getStore().load();
	                        },
	                        failure: function(form, action) { // 添加失败后，提示用户添加异常
	                            Ext.Msg.alert('失败', '操作未完成，原因：' + action.result.failureReason);
	                        }
	                    });
	                    // 关闭当前弹出窗
	                    setTimeout(function() { window.hide(); }, 100);
	                }
	            }
	    	},
	    	'systemuserwindow button[action=cancel]': {
	    		click: function(){
	    			this.getWindow().hide();
	    		}
	    	}
        })
    },
    
    /**
     * Module Launch
     */
	onLaunch: function() {
		// 获得数据源对象
	    var gridPanel = this.getGridPanel(), store = gridPanel.getStore();
	    
        // 装载数据
        store.load();

	    // 设置首行选中
        store.on("load", function(){
        	gridPanel.getSelectionModel().select(0);
        })
	}
});