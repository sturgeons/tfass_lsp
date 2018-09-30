Ext.define('LDPlatformModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: ['LDPlatformModule.view.GridComponent'],

    layout: 'fit',
    items: {
        xtype: 'gridcomponent'
    }
});
