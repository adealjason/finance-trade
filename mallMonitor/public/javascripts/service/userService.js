/**
 * Created by ligaofeng on 2017/2/3.
 * 提供user相关接口
 */
var userDao = require('../dao/userDao.js');
exports.countRegisterUsersGroupByCatName = function () {
    userDao.countRegisterUsersGroupByCatName();
};
