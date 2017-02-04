/**
 * Created by ligaofeng on 2017/2/3.
 * 从数据库中查询出最新的注册人数
 */
var userService = require('../service/userService.js');
exports.countRegisterUsersGroupByCatName = function () {
    userService.countRegisterUsersGroupByCatName();
};
