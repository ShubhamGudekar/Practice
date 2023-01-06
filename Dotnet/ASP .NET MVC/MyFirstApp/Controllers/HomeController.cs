using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MyFirstApp.Models;
using HR;

namespace MyFirstApp.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public IActionResult Index()
    {
        return View();
    }

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }

    public IActionResult LoginUser(string email, string password)
    {
        List<Employee> data = Employee.RestoreData();
        Employee tempEmp = new Employee(email, password);
        if (data.Contains(tempEmp))
        {
            return Redirect("/home/welcome");
        }
        return Redirect("/home/Login");
    }

    public IActionResult Login()
    {
        return View();
    }

    public IActionResult Register()
    {
        return View();
    }

    public IActionResult RegisterUser(string email, string password)
    {
        List<Employee> data = Employee.RestoreData();
        Employee tempEmp = new Employee(email, password);
        if (data.Contains(tempEmp))
        {
            return Redirect("/home/UserAlreadyExist");
        }
        data.Add(tempEmp);
        Employee.SaveData(data);
        return Redirect("/home");
    }

    public IActionResult Welcome()
    {
        return View();
    }

    public IActionResult UserAlreadyExist()
    {
        return View();
    }

}
