//Importing MySQL module
const { createPool } = require(`mysql`);

//Establishing Connection between ExpressJS and MySQL
const mysqldb = createPool({
  host: "43.204.236.82:3306",    //Local Computer
  user: "root",         //UserName
  password: "root123",  //Password
  database: "coursescheduler",     //Database Name
});

//Making db accessible in other Modules
module.exports = mysqldb;
