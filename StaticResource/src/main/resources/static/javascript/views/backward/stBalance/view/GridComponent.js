var render = function(value, metaData, record, rowIndex, colIndex, store, view) {
	if(rowIndex > 0) {
		   var pre = store.getAt(rowIndex - 1);
		   var color = pre.color ? pre.color : 'white';
		   
		   if(pre.get('QADNO') != record.get('QADNO') || pre.get('FABRIC_NO') != record.get('FABRIC_NO')) {
			   color = color === 'white' ? 'gray' : 'white';
		   }
		   metaData.style = "background-color: " + color;
		   record.color = color;
	}
	return value;
};

Ext.define('LDPlatformModule.view.GridComponent', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridcomponent',
	
    enableColumnHide: false,
	sortableColumns: false,
	enableColumnMove: false,
	rowLines: false,
    columns: [{
        header: '总成描述',
        width: 200,
        dataIndex: 'REMARK',
        renderer: render
    }, {
        header: '气袋总成号',
        width: 120,
        dataIndex: 'QADNO',
        renderer: render
    }, {
        header: '布料号',
        width: 120,
        dataIndex: 'FABRIC_NO',
        renderer: render
    }, {
        header: '裁片号',
        width: 120,
        dataIndex: 'CUT_NO',
        renderer: render
    }, {
        header: '裁片数量',
        dataIndex: 'CUT_COUNT',
        renderer: render
    }, {
        header: '裁片辆份',
        dataIndex: 'PCS_COUNT',
        renderer: render
    }, {
        header: '排版套数',
        dataIndex: 'T_RATIO',
        renderer: render
    }, {
        header: '单床套数',
        dataIndex: 'T_PILES',
        renderer: render
    }, {
        header: '短缺数量',
        dataIndex: 'PCS_RES',
        renderer: render
    }, {
        header: '补片优先级',
        dataIndex: 'PCS_LIMIT',
        renderer: render
    },  {
        header: '排版比例',
        dataIndex: 'RESULT',
        renderer: render
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