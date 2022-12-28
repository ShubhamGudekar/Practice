//importing mysql connection from dal
var mysqldb = require('../dal/MySQL/databases');

//displaying all trainers from trainer view (Trainerview table)
exports.getAll = (req, res) => {
    mysqldb.query(`select * from trainerview;`, (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};

//displaying all Trainer  (Trainer  table)
exports.getAllTrainers = (req, res) => {
    mysqldb.query(`select * from trainer;`, (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};


//retrieving single trainer view from trainer id (Trainerview table)
exports.getTrainerById = (req, res) => {
    mysqldb.query(`select * from trainerview where trainerid = ? ;`, [req.params.trainerid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};


//retrieving single trainer details from trainer id (Trainer table)
exports.getTrainerDetailById = (req, res) => {
    mysqldb.query(`select * from trainer where tid = ? ;`, [req.params.trainerid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log(err);
            return;
        }
        res.send(result);
    })
};


//retrieving trainer data from email (Trainer table)
exports.getTrainerDetailsByEmail = (req, res) => {
    mysqldb.query(`select * from trainer where temail = ?;`, [req.params.temail], (err, result) => {
        if (err) {
            console.log(err);
            res.send("Data not Found");
            return;
        }
        res.send(result);
    })
};

//inserting new trainer data into database (Trainer table)
exports.insertTrainer = (req, res) => {
    mysqldb.query(`insert into trainer values(?,?,?,?,?,?,?) ;`,
        [req.body.tid, req.body.tname, req.body.tqualification, req.body.expertise, req.body.temail, req.body.tdob, req.body.mobileno],
        (err, result) => {
            if (err) {
                console.log(err);
                res.send("Trainer not Added");
                return;
            }
            console.log("Trainer added");

            mysqldb.query(`select * from trainer where temail = ?;`, [req.body.temail], (error, resu) => {
                if (error) {
                    console.log(error);
                    res.send("Data not Found");
                    return;
                }
                res.send(resu);
            })

        })
};

//deleteing trainer by id (Trainer table)
exports.deleteTrainerById = (req, res) => {
    mysqldb.query(`delete from trainer where tid = ? ;`, [req.params.trainerid], (err, result) => {
        if (err) {
            res.send("No Data Found");
            console.log("Trainer Not Deleted");
            return;
        }
        res.send("Trainer Deleted");
    })
};


//updating Trainer data using Trainer id (Trainer table)
exports.updateTrainerById = (req, res) => {
    mysqldb.query(`update trainer set tname=?,tqualification=?,expertise=?,temail=?,tdob=?,tmobile_no=? where tid = ? ;`,
        [req.body.tname, req.body.tqualification, req.body.expertise, req.body.temail, req.body.tdob, req.body.mobileno, req.body.tid],
        (err, result) => {
            if (err) {
                res.send("Data Not Updated");
                console.log(err);
                return;
            }
            res.send("Trainer Data Updated");
        })
};