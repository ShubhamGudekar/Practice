using BOL;
using System.Collections.Generic;

public class StudentUtils
{
    public static Student FindById(int id, List<Student> studentData)
    {
        foreach (Student obj in studentData)
        {
            if (obj.Id == id)
                return obj;
        }
        return null;
    }

    public static void UpdateStudentsDetails(Student tStudent)
    {
        Console.WriteLine("Enter");
        Console.WriteLine("1. to update name");
        Console.WriteLine("2. to update Dateofbirth");
        Console.WriteLine("3. to update email");
        Console.WriteLine("4. to update mobile no");
        Console.WriteLine("5. to update address");
        Console.WriteLine("6. to update Qualification");
        Console.WriteLine("0. to return");
        Console.WriteLine("Your Choice ");
        int choice = int.Parse(Console.ReadLine());
        switch (choice)
        {
            case 1:
                Console.WriteLine("Enter New Name ");
                tStudent.Name = Console.ReadLine();
                Console.WriteLine("Name Updated Successfully\n" + tStudent);
                break;
            case 2:
                Console.WriteLine("Enter New DateofBirth ");
                tStudent.DateOfBirth = DateTime.Parse(Console.ReadLine());
                Console.WriteLine("DateOfBirth Updated Successfully\n" + tStudent);
                break;
            case 3:
                Console.WriteLine("Enter New Email ");
                tStudent.Email = Console.ReadLine();
                Console.WriteLine("Email Updated Successfully\n" + tStudent);
                break;
            case 4:
                Console.WriteLine("Enter New MobileNo ");
                tStudent.MobileNo = long.Parse(Console.ReadLine());
                Console.WriteLine("MobileNo Updated Successfully\n" + tStudent);
                break;
            case 5:
                Console.WriteLine("Enter New Address ");
                tStudent.Address = Console.ReadLine();
                Console.WriteLine("Address Updated Successfully\n" + tStudent);
                break;
            case 6:
                Console.WriteLine("Enter New Qualification ");
                tStudent.Qualification = Console.ReadLine();
                Console.WriteLine("Qualification Updated Successfully\n" + tStudent);
                break;
            case 0:
                Console.WriteLine("Returning...");
                break;

            default:
                Console.WriteLine("Invalid Choice");
                break;
        }
    }
}