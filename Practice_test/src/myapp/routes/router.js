//importing student controller to use its methods
var studentcontroller = require('../controller/studentController');
var trainercontroller = require('../controller/trainerController');

module.exports = function (app) {


    //routing to student controller's getALL()
    app.route('/studentview').get(studentcontroller.getAll);

    //routing to student controller's getById()
    app.route('/studentview/:studentid').get(studentcontroller.getStudentById);

    //routing to student controller's insertStudent()
    app.route('/student').post(studentcontroller.insertStudent);

    //routing to student controller's getAllStudents()
    app.route('/student').get(studentcontroller.getAllStudents);

    //routing to student controller's StudentDetailById()
    app.route('/student/:studentid').get(studentcontroller.getStudentDetailById);

    //routing to student controller's deleteStudentById()
    app.route('/student/:studentid').delete(studentcontroller.deleteStudentById);

    //routing to student controller's updateStudentById()
    app.route('/student/:studentid').put(studentcontroller.updateStudentById);

    //routing to student controller's getByEmail()
    app.route('/student/details/:semail').get(studentcontroller.getStudentDetailsByEmail);


    //Trainer Router
    //routing to trainer controller's getALL()
    app.route('/trainerview').get(trainercontroller.getAll);

    //routing to trainer controller's getById()
    app.route('/trainerview/:trainerid').get(trainercontroller.getTrainerById);

    //routing to trainer controller's insertTraineer()
    app.route('/trainer').post(trainercontroller.insertTrainer);

    //routing to trainer controller's getAllTrainers()
    app.route('/trainer').get(trainercontroller.getAllTrainers);

    //routing to trainer controller's TrainerDetailById()
    app.route('/trainer/:trainerid').get(trainercontroller.getTrainerDetailById);

    //routing to trainer controller's deleteTrainerById()
    app.route('/trainer/:trainerid').delete(trainercontroller.deleteTrainerById);

    //routing to trainer controller's updateTrainerById()
    app.route('/trainer/:trainerid').put(trainercontroller.updateTrainerById);

    //routing to trainer controller's getByEmail()
    app.route('/trainer/details/:temail').get(trainercontroller.getTrainerDetailsByEmail);






};