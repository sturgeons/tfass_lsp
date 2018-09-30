/**
 * 基本的查询工具条
 */
Ext.define('Ext.plugins.ExportToExcelButton', {
	extend: 'Ext.Button',
	alias: 'widget.exporttoexcelbutton',
	
	gridPanel: Ext.empty,
	text: '导出表格',

	// 组件初始化函数，在组建初始化的时候，可以进行内部组件绑定
    initComponent: function() {
    	var me = this;
    	
        Ext.apply(this, {
            text: this.text,
		   	iconCls: 'excel',
	   		action: 'export',
	   		listeners: {
	   			'click': function(){
	        		var meta = [], data = [];
	        		
	        		// statistics grid panel meta data.
	        		Ext.each(me.gridPanel.columns, function(col, index){ if(col.dataIndex) {meta.push(col.text);} });
	        		// statistics grid panel records.
	        		me.gridPanel.getStore().each(function(rec){ data.push(rec.data); });
	        		
	    			Ext.Ajax.request({
	    			      url:"v1/exportExcel",
	    			      method: 'post',
	    			      params: {
	    			    	  meta: JSON.stringify(meta),
	    			    	  data: JSON.stringify(data)
	    			      },
	    			      success:function(res){
	    			          window.location.href = eval("(" + res.responseText + ")").path;
	    			      }
	    			});
	        	}
	   		}
        });
        return this.callParent(arguments);
    }
})