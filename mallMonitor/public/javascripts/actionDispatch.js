/**
 * Created by ligaofeng on 2017/2/3.
 * used for dispatch action
 */
var registerAction = require('./action/userAction.js');
var createOrderAction = require('./action/orderAction.js');
exports.dispatch= function (action) {
    switch (action){
        case "register":
            registerAction.countRegisterUsersGroupByCatName();
            break;
        case "createOrder":
            createOrderAction.countOrderAmountByProvince();
            break;
    }
};
