namespace HR;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

public class Employee
{
    private static string fileName = @".\empData.json";

    public string Email { get; set; }

    public string Password { get; set; }

    public Employee(string email, string password)
    {
        this.Email = email;
        this.Password = password;
    }

    public override bool Equals(object? obj)
    {
        if (obj is Employee && obj != null)
        {
            return this.Email.Equals(((Employee)obj).Email) && this.Password.Equals(((Employee)obj).Password);
        }
        return false;
    }

    public static void SaveData(List<Employee> empData)
    {
        var options = new JsonSerializerOptions { IncludeFields = true };
        var dataJson = JsonSerializer.Serialize(empData, options);
        File.WriteAllText(fileName, dataJson);
    }

    public static List<Employee> RestoreData()
    {
        string jsonString = File.ReadAllText(fileName);
        List<Employee>? empData = JsonSerializer.Deserialize<List<Employee>>(jsonString);
        return empData;
    }

}