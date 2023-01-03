using BOL;
using utils;

List<Student> studentData = IOUtils.RestoreData();
bool exitFlag = false;
Student tempStudent = null;
int tempStudentID = 0;
Console.WriteLine("Welcome to Transflower's Student Page");
while (!exitFlag)
{
    Console.WriteLine("Enter");
    Console.WriteLine("1. to insert new Student Details");
    Console.WriteLine("2. to display all students");
    Console.WriteLine("3. to find student based on id");
    Console.WriteLine("4. to update student details");
    Console.WriteLine("5. to delete student details");
    Console.WriteLine("0. to exit");
    int? choice = int.Parse(Console.ReadLine());
    try
    {
        switch (choice)
        {
            case 1:
                Console.WriteLine("Enter Student Name : ");
                string? sName = Console.ReadLine();
                Console.WriteLine("Enter Student DateOfBirth : ");
                string? sDob = Console.ReadLine();
                Console.WriteLine("Enter Student Email : ");
                string? sEmail = Console.ReadLine();
                Console.WriteLine("Enter Student MobileNo : ");
                long sMob = long.Parse(Console.ReadLine());
                Console.WriteLine("Enter Student Address : ");
                string? sAdd = Console.ReadLine();
                Console.WriteLine("Enter Student Qualification : ");
                string? sQual = Console.ReadLine();
                tempStudent = new Student(sName, sDob, sEmail, sMob, sAdd, sQual);
                Console.WriteLine("Student Added \n Student ID generated : " + tempStudent.Id);
                studentData.Add(tempStudent);
                break;

            case 2:
                studentData.ForEach(obj => Console.WriteLine(obj));
                break;

            case 3:
                Console.WriteLine("Enter Student ID: ");
                tempStudentID = int.Parse(Console.ReadLine());
                tempStudent = StudentUtils.FindById(tempStudentID, studentData);
                if (tempStudent != null)
                {
                    Console.WriteLine("Student Found \n" + tempStudent);
                }
                else
                    Console.WriteLine("Student Not Found");
                break;

            case 4:
                Console.WriteLine("Enter Student ID: ");
                tempStudentID = int.Parse(Console.ReadLine());
                tempStudent = StudentUtils.FindById(tempStudentID, studentData);
                if (tempStudent != null)
                {
                    Console.WriteLine("Student Found \n" + tempStudent);
                    StudentUtils.UpdateStudentsDetails(tempStudent);
                }
                else
                    Console.WriteLine("Student Not Found");
                break;


            case 5:
                Console.WriteLine("Enter Student ID: ");
                tempStudentID = int.Parse(Console.ReadLine());
                tempStudent = StudentUtils.FindById(tempStudentID, studentData);
                if (tempStudent != null)
                {
                    Console.WriteLine("Student Found \n" + tempStudent);
                    studentData.Remove(tempStudent);
                    Console.WriteLine("Student Details Deleted");
                }
                else
                    Console.WriteLine("Student Not Found");
                break;

            case 0:
                Console.WriteLine("Tata Bye-Bye");
                exitFlag = true;
                break;

            default:
                Console.WriteLine("Invalid Choice");
                break;
        }//switch
    }
    catch (Exception? e)
    {
        Console.WriteLine("Exception : " + e.Message);
    }
    finally
    {
        IOUtils.SaveData(studentData);
    }
}//while