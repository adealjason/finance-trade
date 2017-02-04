/**
 * Created by ligaofeng on 2017/2/1.
 */
var index = require('./index');
var mallEventServer=require('./mallEventServer');

module.exports = function (app) {
    app.use('/', index);
    app.use('/monitor',index);
    app.use('/mallEventServer',mallEventServer);
};