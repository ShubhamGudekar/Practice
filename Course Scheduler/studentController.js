//importing mysql connection from dal
var mysqldb = require('../../dal/MySQL/databases');


//displaying all students from student view
exports.getAll=(req,res)=>{
mysqldb.query(`select * from studentview`,(err, result)=>{
    if(err){
        res.send("No Data Found");
        return;
    }
    res.send(result);
})
};

//retrieving single student data from student id
exports.getStudentById=(req,res)=>{
    mysqldb.query(`select * from studentview where studentid = ? ;`,[req.params.studentid],(err,result)=>{
        if(err){
            res.send("No Data Found");
            return;
        }
        res.send(result);
    })
};


