Ext.define('MenuItemModule.controller.MenuItemController', {
    extend: 'Ext.app.Controller',
    stores: ['MenuItem'],// 存储器
    refs: [
       {ref: 'gridPanel', selector: 'menuitemgrid'},
       {ref: 'window', selector: 'menuitemwindow'},
       {ref: 'formPanel', selector: 'menuitemform'},
       {ref: 'submitBtn', selector: 'menuitemwindow button[action=submit]'}
    ],
    
    // Cotroller的业务处理
    init: function() {
	    this.control({
	    	'menuitemgrid button[action=add]':{
	    		click: function(){
	    			// 获得窗体对象的引用
	            	var menuItemWindow = this.getWindow();
	            	// 判断窗体对象是否存在, 如果不存在，就创建一个新的窗体对象
	            	if(!menuItemWindow){menuItemWindow = Ext.create('MenuItemModule.view.MenuItemWindow');}
	            	// 在执行新增业务的时候，要把窗体的内容清空
	                this.getFormPanel().getForm().reset();
	                
	                menuItemWindow.show(); // 显示窗体
	                menuItemWindow.center();// 窗体居中显示
	            }
	        },
	        'menuitemgrid button[action=modify]': {
	        	click: function(){
	                var sm = this.getGridPanel().getSelectionModel();// 获得grid的SelectionModel
	                var record = sm.getLastSelected();// 当前选中记录

	                // 只有存在选中行的时候才显示修改窗口
	                if (record) {
		            	var menuItemWindow = this.getWindow();
	                	if(!menuItemWindow){menuItemWindow = Ext.create('MenuItemModule.view.MenuItemWindow');}
	                	this.getFormPanel().getForm().loadRecord(record); // 加载要编辑的对象
	                	
	                    menuItemWindow.show(); // 显示窗体
	                    menuItemWindow.center();
	                }
	            }
	        },
	        'menuitemgrid button[action=del]': {
	        	click: function(){
	            	// 表格对象
	                var gridObj = this.getGridPanel();
	                var sm = this.getGridPanel().getSelectionModel();// 获得grid的SelectionModel
	                
	                // 如果选中行无效，则不相应用户的删除操作
	                if (sm.getSelection().length < 1) {
	                    return false;
	                }
	                // 当前选中行
	                var rowId = sm.getLastSelected().get('sysid');

	                // 提示用户确认删除操作
	                Ext.MessageBox.confirm('确认删除', '你确定要删除选中记录吗?', function(res) {
	                    if (res === 'yes') { // 用户确认要执行删除操作
	                        Ext.Ajax.request({
	                            url: 'services/delMenuItem',
	                            params: { sysid: rowId },
	                            method: 'POST',
	                            success: function(response, options) {
	                                // 生成回馈对象
	                                var obj = Ext.decode(response.responseText);

	                                // 根据不同的删除状态，做不同的提示
	                                if (obj.success) {
	                                    gridObj.getStore().reload();
	                                } else {
	                                    Ext.MessageBox.alert('失败', '删除失败, 原因：' + obj.failureReason);
	                                }
	                            },
	                            failure: function(response, options) {
	                                Ext.MessageBox.alert('失败', '请求超时或网络故障, 错误编号：' + response.status);
	                            }
	                        });
	                    }
	                });
	            }
	        },
            'menuitemform textfield[name=itemlink]': {// 密码项目的事件处理
                specialkey: function(field, e){
                    if (e.getKey() == e.ENTER) {
                        this.getSubmitBtn().getEl().dom.click();
                    }
                }
            },
	        'menuitemwindow button[action=submit]': {
	        	click: function(){
	        		// form表单对象 
	                var formObj = this.getFormPanel().getForm();
	                var window = this.getWindow();
	                var gridPanel = this.getGridPanel();
	                
	                // 检查表单项的录入是否存在问题
	                if (formObj.isValid()) {
	                    // 提交表单
	                    formObj.submit({
	                        waitMsg: '数据正在处理请稍后', // 提示信息  
	                        waitTitle: '提示', // 标题  
	                        url: 'services/menuItemModify', // 请求的url地址  
	                        method: 'POST', // 请求方式  
	                        success: function(form, action) { // 添加数据成功后，重新加载数据源刷新表单 
	                        	gridPanel.getStore().loadRawData();
	                        	gridPanel.getStore().load();
	                        },
	                        failure: function(form, action) { // 添加失败后，提示用户添加异常
	                            Ext.Msg.alert('失败', '操作未完成，原因：录入信息错误');
	                        }
	                    });
	                    // 关闭当前弹出窗
	                    setTimeout(function() {window.hide();}, 100);
	                }
	        	}
	        },
	        'menuitemwindow button[action=cancel]': {
	        	click: function(){
	        		this.getWindow().hide();
	        	}
	        },
	        'menuitemwindow': {
	        	show: function(){
    	            Ext.getCmp('itemname').focus(true, 100);
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
        store.load({params: { start: 0, limit: 25 }});

	    // 设置首行选中
        store.on("load", function(){
        	gridPanel.getSelectionModel().select(0);
        })
	}
});