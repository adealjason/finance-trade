/**
 * Created by ligaofeng on 2017/2/3.
 */
var orderDao = require('../dao/orderDao.js');
exports.countOrderAmountByProvince = function () {
    orderDao.countOrderAmountByProvince();
};
