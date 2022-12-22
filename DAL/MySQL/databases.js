//Importing MySQL module
const { createPool } = require(`mysql`);

//Establishing Connection between ExpressJS and MySQL
const pool = createPool({
  host: "localhost",    //Local Computer
  user: "root",         //UserName
  password: "root123",  //Password
  database: "test",     //Database Name
});

//Query to fire in MySQL
pool.query(`select * from emp where empno = ? ;`,[7934],(err, result) => { //empno = 7934
    //incase of error display the error in console
    if (err) {
      return console.log(err);
    }
    //Connection Done Successfully
    console.log("Database Connectivity Done");
    return console.log(result);
  }
);

//Making db accessible in other Modules
module.exports = pool;
