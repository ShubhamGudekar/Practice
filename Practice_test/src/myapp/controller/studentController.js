//importing mysql connection from dal
var mysqldb = require('../dal/MySQL/databases');

//displaying all students from student view (Studentview table)
exports.getAll = (req, res) => {
    mysqldb.query(`select * from studentview;`, (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};

//displaying all students from student (Student table)
exports.getAllStudents = (req, res) => {
    mysqldb.query(`select * from student;`, (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};

//retrieving single student view from student id (Studentview table)
exports.getStudentById = (req, res) => {
    mysqldb.query(`select * from studentview where studentid = ? ;`, [req.params.studentid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};

//retrieving single student details from student id (Student table)
exports.getStudentDetailById = (req, res) => {
    mysqldb.query(`select * from student where sid = ? ;`, [req.params.studentid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};

//retrieving student data from email (Student table)
exports.getStudentDetailsByEmail = (req, res) => {
    mysqldb.query(`select * from student where semail = ?;`, [req.params.semail], (err, result) => {
        if (err) {
            console.log(err);
            res.send("Data not Found");
            return;
        }
        res.send(result);
    })
};

//inserting new student data into database (Student table)
exports.insertStudent = (req, res) => {
    mysqldb.query(`insert into student values(default,?,?,?,?,?,?) ;`,
        [req.body.sname, req.body.saddress, req.body.mobile, req.body.semail, req.body.dob, req.body.squalification],
        (err, result) => {
            if (err) {
                console.log(err);
                res.send("Student not Added");
                return;
            }
            console.log("Student added");

            //Intially tried to redirect to getStudentByEmail using generateEmailUrl but it is not redirecting (data not retrived in postman)
            //generateEmailUrl(req.body.semail);

            //Alternatively wrote directly wrote the querry here and this is working 
            mysqldb.query(`select * from student where semail = ?;`, [req.body.semail], (error, resu) => {
                if (error) {
                    console.log(error);
                    res.send("Data not Found");
                    return;
                }
                res.send(resu);
            })

        })
};

//redirecting to get data by studentemail 
generateEmailUrl = (studentemail) => {
    var surl = {
        uri: 'http://localhost:4000/student/details/' + studentemail,
        method: 'GET'
    }
    request(surl, (error, response) => {
        if (error) {
            console.log(error);
            return;
        }
        console.log(surl);
    });
}

//deleteing student by id (Student table)
exports.deleteStudentById = (req, res) => {
    mysqldb.query(`delete from student where sid = ? ;`, [req.params.studentid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log("Student Not Deleted");
            return;
        }
        res.send("Student Deleted");
    })
};

//updating Student data using student id (Student table)
exports.updateStudentById = (req, res) => {
    mysqldb.query(`update student set sname=?,saddress=?,mobile=?,semail=?,dob=?,squalification=? where sid = ? ;`,
        [req.body.sname, req.body.saddress, req.body.mobile, req.body.semail, req.body.dob, req.body.squalification, req.body.sid],
        (err, result) => {
            if (err) {
                res.send("Data Not Updated");
                console.log(err);
                return;
            }
            res.send("Student Data Updated");
        })
};