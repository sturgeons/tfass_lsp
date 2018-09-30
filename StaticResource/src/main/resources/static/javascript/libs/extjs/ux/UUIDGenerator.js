Ext.define('Ext.ux.UUIDGenerator', {
    extend: 'Ext.data.IdGenerator',
    alias: 'idgen.uuidgenerator',

    generate: function () {
        return Ext.data.IdGenerator.get('uuid').generate().replace(/-/g, '');
    }
});