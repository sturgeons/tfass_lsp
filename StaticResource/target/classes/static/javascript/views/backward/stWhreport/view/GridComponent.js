Ext.define('LDPlatformModule.view.GridComponent', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridcomponent',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	rowLines: false,
    columns: [{
        header: '发泡方向盘',
        width: 160,
        dataIndex: 'FAPAO_QADNO'
    }, {
        header: '发泡库存',
        width: 80,
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	metaData.style = "background-color: RGB(0, 112, 192);color:white;";
        	
	        return value;
	    },
        dataIndex: 'FAPAO_COUNT'
    }, {
        header: '缝皮在制',
        width: 80,
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	metaData.style = "background-color:RGB(153, 51, 102);color:white;";
        	
	        return value;
	    },
        dataIndex: 'FENGPI_COUNT'
    }, {
        header: '缝皮方向盘',
        width: 160,
        dataIndex: 'FENGPI_QADNO'
    }, {
        header: '描述',
        width: 160,
        dataIndex: 'REMARK'
    }, {
        header: '装配在制',
        width: 80,
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	metaData.style = "background-color:RGB(153, 51, 102);color:white;";
        	
	        return value;
	    },
        dataIndex: 'STORE_COUNT'
    }, {
        header: '装配方向盘',
        width: 200,
        dataIndex: 'FXP_QADNO'
    }, {
        header: '合格待入库',
        width: 100,
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	metaData.style = "background-color:RGB(0, 176, 80);color:white;";
        	
	        return value;
	    },
        dataIndex: 'OK_COUNT'
    }, {
        header: '待返修',
        width: 70,
        renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
        	metaData.style = "background-color:RGB(255, 0, 0);color:white;";
        	
	        return value;
	    },
        dataIndex: 'REWORK_COUNT'
    }, {
        header: '车型',
        dataIndex: 'QAD_MODEL'
    }],

    /**
     * Component Init
     */
    initComponent: function() {
        // Create Store Object
        var store = Ext.create('LDPlatformModule.store.Store');
        var me = this;        

        // Copy properties to Origin Object
        Ext.apply(this, {
            store: store,
        	merge: function(panel, colstart, colend) {
        		var pre_node;
        		var store = {};// 存放合并开始行信息
        		Ext.each(me.view.getNodes(), function(node, index) {// 递归查询所有的行对象
        			var cols = Ext.get(node).query('td');// 查询行中的所有单元格对象
        			var pre_col1 = pre_node ?  Ext.get(Ext.get(pre_node).query('td')[0]).query('div')[0].innerHTML : '';
        			
        			for(var i = colstart; i < Math.min(colend || 255, cols.length); i++){// 按照Excel的标准，最大列数位255
	        				try {//  使用try...catch模块，可以减少过多的校验逻辑
		        					var first = Ext.get(store[i].node),  second = Ext.get(cols[i]);
		
		        					if(pre_col1 === Ext.get(cols[0]).query('div')[0].innerHTML) {
				        					if(first.query('div')[0].innerHTML === second.query('div')[0].innerHTML) {// 如果两行数据相同就需要合并
				        						if(!first.prev() || (first.prev().query('div')[0].innerHTML === second.prev().query('div')[0].innerHTML)){
					        						first.set({ rowSpan: ++store[i].count, style: "vertical-align: middle;background-color:" + first.query('div')[0].style.backgroundColor });
					        						second.setStyle({ 'display': 'none' });// 隐藏需要合并的单元格
					        						
					        						continue;
				        						}
				        					}
		        					}
	        				} catch(e) {}
        				// 记录合并开始位置以及dom基本信息
        				store[i] = {node: cols[i], count: 1};
        			}
        			pre_node = node;
        		});
        	},
            bbar: [Ext.create('Ext.plugins.ExportToExcelButton', {gridPanel: me}),'->', {
	          iconCls: 'x-tbar-loading',
	          style: 'margin-right:20px',
	          listeners: {
	              click: function() {
	                  store.reload();
	              }
	          }
	        }]
        });
        // Call Parent Constructor
        this.callParent(arguments);
    }
});