var express = require("express");
var app = express();
var bodyParser = require('body-parser');
var routes = require('./routes/router');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// app.get("/",function(req,resp){
//     resp.send(data);
// })


routes(app);

app.listen(4000);
console.log("server is listening at port 4000");