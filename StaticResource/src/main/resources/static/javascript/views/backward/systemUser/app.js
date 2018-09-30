requirejs(['utils/md5']);

/**
 * 用户管理
 * 
 * @Author Renjian
 */
Ext.application({
    name: 'SystemUserModule',
    appFolder: 'javascript/views/backward/systemUser',
    controllers: [
      'SystemUserController'
    ],// 控制器

    autoCreateViewport: true,
    
    /**
     * 防止重复加载TreePanel
     */
    launch: function(){
    	Ext.create('SystemUserModule.view.SystemUserWindow');
    }
});

