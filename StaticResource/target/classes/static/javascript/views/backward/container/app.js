/**
 * 网站主功能页面
 * 
 * @Author Renjian
 */
Ext.application({
    name: 'MainModule',// 模块名称
    appFolder: 'javascript/views/backward/container',// 模块文件路径 
    controllers: ['TreePanelController'],// 加载控制器控件
    
    autoCreateViewport: true
});

