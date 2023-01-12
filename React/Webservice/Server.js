const express = require("express");
const app = express();
const { createPool } = require("mysql");

var path = require("path");
var bodyparser = require("body-parser");
//var routes = require("./routes/routers")

///define middleware
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({ extended: false }));
app.use(function (req, res, next) {
	res.setHeader("Access-Control-Allow-Origin", "*");
	res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	res.setHeader("Access-Control-Allow-Headers", "Content-Type");
	res.setHeader("Access-Control-Allow-Credentials", true);
	next();
});

//app.use("/", routes);

const mysqldb = createPool({
	host: "localhost",
	user: "root",
	password: "root123",
	database: "wptpractice",
});

app.get("/", (req, res) => {
	mysqldb.query(`select * from studentDetails`, (result, err) => {
		if (err) {
			res.send(err);
			return;
		}
		res.send(result);
	});
});

app.post("/", (req, res) => {
	mysqldb.query(`insert into studentRegister values(?,?,?) ;`, [req.body.prn, req.body.password, req.body.reEnterPassword], (err, result) => {
		console.log(req.body.prn + req.body.password + req.body.reEnterPassword);
		if (err) {
			console.log(err);
			res.send("Student not Added");
			return;
		}
		res.send("Student Added");
	});
});

app.listen(4000);
console.log("server is listening at 4000");
