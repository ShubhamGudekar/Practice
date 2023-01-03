namespace BOL;

[Serializable]
public class Student
{
    private static int idCounter = 100;
    public int Id { get; set; }

    public string? Name { get; set; }

    public DateTime DateOfBirth { get; set; }

    public string? Email { get; set; }

    public long MobileNo { get; set; }

    public string? Address { get; set; }

    public string? Qualification { get; set; }

    public Student(string name, string dob, string email, long mobileNo, string address, string qualification)
    {
        this.Id = idCounter;
        this.Name = name;
        this.DateOfBirth = DateTime.Parse(dob);
        this.Email = email;
        this.MobileNo = mobileNo;
        this.Address = address;
        this.Qualification = qualification;
        idCounter++;
    }

    public Student() : this("abc", "2000-01-01", "abc@gmail.com", 0123456789, "tuv", "xyz")
    {

    }

    public override string ToString()
    {
        string stud = "Student[Id : " + this.Id + " | Name : " + this.Name + " | Email : " + this.Email + " | Mobile : " + this.MobileNo + " | DOB : "
            + this.DateOfBirth.ToShortDateString() + " | Address : " + this.Address + " | Qualification : " + this.Qualification + " ]";
        return stud;
    }

    // public override bool Equals(object obj)
    // {
    //     if (obj.GetType == Student)  //get BOL.Student as op for object of student 
    //     {
    //         if ((Student(obj)).Id == this.Id)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    //}

}