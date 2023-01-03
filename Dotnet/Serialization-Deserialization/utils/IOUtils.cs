namespace utils;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using BOL;

public class IOUtils
{
    private static string fileName = @"..\studentData.json";

    public static void SaveData(List<Student> studentData)
    {
        var options = new JsonSerializerOptions { IncludeFields = true };
        var dataJson = JsonSerializer.Serialize(studentData, options);
        File.WriteAllText(fileName, dataJson);
    }

    public static List<Student> RestoreData()
    {
        string jsonString = File.ReadAllText(fileName);
        List<Student>? studentData = JsonSerializer.Deserialize<List<Student>>(jsonString);
        return studentData;
    }

}
