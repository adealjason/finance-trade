/**
 * Created by ligaofeng on 2017/2/1.
 */
var express = require('express');
var router = express.Router();
var actionDispatch = require('../public/javascripts/actionDispatch.js');

/* GET home page. */
router.get('/', function(req, res, next) {
    var action=req.query.action;
    actionDispatch.dispatch(action);
    res.send('success');
});

module.exports = router;