using Microsoft.AspNetCore.Mvc;
using BOL;
using DAL;

namespace test.Controllers;

[ApiController]
[Route("[controller]")]
public class DepartmentController : ControllerBase
{
    private readonly ILogger<DepartmentController> _logger;

    public DepartmentController(ILogger<DepartmentController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    public IEnumerable<Department> GetAllDept()
    {
        DBManager db = new DBManager();
        return db.GetAll();
    }

    [HttpGet("{id}")]
    public Department GetDeptById(int id)
    {
        DBManager db = new DBManager();
        return db.GetById(id);
    }

    [HttpPost]
    public void insertDept(Department dept)
    {
        DBManager db = new DBManager();
        db.Insert(dept);
    }

    [HttpDelete("{id}")]
    public void deleteDept(int id)
    {
        DBManager db = new DBManager();
        db.Delete(id);
    }

    [HttpPut("{id}")]
    public void updateDept(Department dept)
    {
        DBManager db = new DBManager();
        db.Update(dept);
    }
}
