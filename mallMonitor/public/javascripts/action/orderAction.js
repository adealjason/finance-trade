/**
 * Created by ligaofeng on 2017/2/3.
 * 统计各省份的销售量
 */
var orderService = require('../service/orderService.js');
exports.countOrderAmountByProvince = function () {
    orderService.countOrderAmountByProvince();
};