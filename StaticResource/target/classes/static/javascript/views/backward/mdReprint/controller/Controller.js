Ext.define('LDPlatformModule.controller.Controller', {
    extend: 'Ext.app.Controller',

    refs: [
       {ref: 'gridPanel', selector: 'gridcomponent'},
       {ref: 'partGridPanel', selector: 'partgrid'}
    ],
    
    params : {
		 RECORD_NO: Ext.util.Format.date(new Date(), 'ymd'),
		 PART_NO: ''
    },
    
    init: function() {// Cotroller的业务处理
	    this.control({
	    	'textfield[name=searchField]': {
	            specialkey: function(field, e){
	                if (e.getKey() == e.ENTER) {
	                	this.params.PART_NO = Ext.util.Format.uppercase(field.getValue());
	                	
	                    this.getGridPanel().getStore().reload({params: this.params});
	                }
	            }
	        },
	        'gridcomponent': {
	        	itemclick: function(obj, record, e) {
	            	this.reloadPartGrid(record);
	            }
	        },
	    	'button[action=print]':{
	    		click: function(){	                
	    			 var sm = this.getGridPanel().getSelectionModel();// 获得grid的SelectionModel
	    			 
	    			 Ext.Ajax.request({
                         url: 'v1/printService/STprintdataService',
                         method: 'POST',
                         params:{
                        	 print_date: sm.getLastSelected().get('PRINT_DATE'),
                        	 datas: sm.getLastSelected().get('CONTENT'),
                        	 pageno: sm.getLastSelected().get('RECORD_NO')
                         },
                         success: function(response, options) {
//                             Ext.MessageBox.alert('成功', '补打指令已执行');
                         },
                         failure: function(response, action) {
                             Ext.MessageBox.alert('失败', '操作失败：' + action.result.failureReason);
                         }
                     });
	            }
	        },
	    	'datefield':{
	    		change: function(obj, val){
                	 this.params.RECORD_NO = Ext.util.Format.date(val, 'ymd');
                	
	    			 this.getGridPanel().getStore().reload({params: this.params});
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
        store.load({params: this.params}).on({
            "refresh": function(){
            	gridPanel.getSelectionModel().deselectAll();
            	gridPanel.getSelectionModel().select(0);
            },
            "load": function(obj, records) {
            	me.reloadPartGrid(records[0]);
            	gridPanel.down('button[action=print]').disabled = store.count() === 0;
            	
            	gridPanel.down('textfield[name=searchField]').focus();
            }
        })
	},
	// 数据集合默认选中第一行
    reloadPartGrid: function(record) { 
        // 检查记录是否存在
        if (record) {
            return this.getPartGridPanel().getStore().loadData(eval('(' + record.get('CONTENT') + ')'));
        }
        this.getPartGridPanel().getStore().loadData([]);
    }
});