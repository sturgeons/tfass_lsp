Ext.define('MainModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	
	id: 'dataGrid',
    selModel: { checkOnly: true },
    defaults: { sortable: true },
    columns: [{ 
        header: '提交日期',
    	width: 90,
        dataIndex: 'CREATED',
        renderer: function(val) {
        	return val ? Ext.Date.format(new Date(val), 'Y-m-d') : val;
        } 
	},{ 
        header: '生产线',
        dataIndex: 'LINE'
	},  { 
        header: '产品',
        width: 160,
        dataIndex: 'QADNO'
	},  { 
        header: '工序',
        width: 70,
        dataIndex: 'OP'
	},  {
        header: '文件类型',
        width: 120,
        dataIndex: 'CHECK_TYPE'
    },  {
        header: '检查内容',
        flex: 1,
        dataIndex: 'CONTENT'
    }, { 
        header: '班次',
    	width: 50,
        dataIndex: 'SHIFT'
	}, {
		 header: '目标值',
        width: 220,
        renderer: function(value, meta, record) {
        	if(record.get('DATA_TYPE') === 2) {
      		  		return "合格";
	      	}
	      	
	      	var low = record.get('TOLERANCE_LIMIT_LOWER');
	      	var upper = record.get('TOLERANCE_LIMIT_ON');
	      	var res = "";
	      	
	      	if(low.toString().length > 0) {
	      		res += low + " "+ record.get('LOWER_SIGN') + " ";
	      	}
	      	res += '目标值';
	      	if(upper.toString().length > 0) {
	      		res += " " + record.get('UPPER_SIGN') + " " + upper 
	      	}
        	return res ===  '目标值' ? ''  : "("+ res + ")" + record.get('UNIT_NAME');
        }
    }, {
        header: '实际值',
        width: 100,
        dataIndex: 'RESULT_VAL',
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	if("不合格" === value) {// 逻辑检验结果为不合格的
            	 metaData.style = "background-color: RGB(255, 0, 0)";
        	} else if (value.trim().length === 0) {// 未填的数据
        		 value = "&nbsp";
           	     metaData.style = "background-color: yellow";
        	} else if(1 === record.get('DATA_TYPE')) {
        		var low = record.get('TOLERANCE_LIMIT_LOWER');
		      	var upper = record.get('TOLERANCE_LIMIT_ON');
		      	var res = true;
		      	
		      	if(low.toString().length > 0) {
		      		res =  res & eval(low + " "+ record.get('LOWER_SIGN') + value);
		      	}
		      	if(upper.toString().length > 0) {
		      		res = res & eval(value + record.get('UPPER_SIGN') + " " + upper);
		      	}
		      	
    		    if(!res) {// 取值异常
               		   metaData.style = "background-color: RGB(255, 0, 0)";
    		    }
	    	}
	        return value;
	    }
    }, { 
        header: '录入人员',
        dataIndex: 'EM_NAME'
	}],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('MainModule.store.Store');

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});