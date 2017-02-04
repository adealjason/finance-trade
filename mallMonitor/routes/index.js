var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  //res.render('monitorCore', getJsonData());
    res.render('monitorCore',getJsonData());
});

function getJsonData() {
    return { title: 'Mall Monitor' };
}

module.exports = router;
