package dao;

import pojo.Department;
import pojo.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmpDetails(Employee newEmp) {
		String msg = "Employee Not Added";

		// get session from session factory
		Session session = getFactory().getCurrentSession();

		// get transaction
		Transaction transaction = session.beginTransaction();

		try {
			// Session API : public Serializable save(Object
			// transientObjRef) throws HibernateExc.
			Long empId = (Long) session.save(newEmp);
			// newEmp : PERSISTENT => entity ref added to L1 cache
			transaction.commit();// Hibernate perform auto. dirty chking --> session.flush()
			// DML --insert --session.close() => L1 cache destroyed ,
			// rets DB cn to the DBCP
			// (db connection pool)
			// newEmp : DETACHED (from L1 cache)
			msg = "Employee Added, ID =" + empId;
		} catch (RuntimeException e) // as hibernate converts all checked exception to unchecked exceptions
		{
			if (transaction != null)
				transaction.rollback();
			// rethrow the exception so that the caller will know that exception is raised
			throw e;
		}
		return msg;
	}

	@Override
	public List<Employee> getAllEmpWithSalGtThan(Department dept, double salary) {
		List<Employee> empData = null;
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String jpql = "select e from Employee e where e.dept=:tempDept and e.salary>:sal";
		try {
			empData = session.createQuery(jpql, Employee.class).setParameter("tempDept", dept)
					.setParameter("sal", salary).getResultList();

			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return empData;
	}

	@Override
	public List<Employee> getAllPermanentEmployee() {
		List<Employee> empData = null;
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String jpql = "select new pojo.Employee(id,firstName,lastName,salary) from Employee e where e.isPermanent=true";
		try {
			empData = session.createQuery(jpql, Employee.class).getResultList();

			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return empData;
	}

	@Override
	public String transferEmployee(String firstName, String lastName, Department newDept,double salaryRaise) {
		String msg = "Department and Salary not Changed";
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String jpql = "select e from Employee e where e.firstName=:fn and e.lastName=:ln";
		try {

			Employee fetchedEmp = session.createQuery(jpql, Employee.class).setParameter("fn", firstName)
					.setParameter("ln", lastName).getSingleResult();

			fetchedEmp.setDept(newDept);
			fetchedEmp.setSalary(fetchedEmp.getSalary()+salaryRaise);

			transaction.commit();
			msg = "Department and Salary Changed Successfully";

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteTemporaryEmployee() {
		String msg="Employee Deletion Failed";
		int empDeleted;
		Session session = getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String jpql = "delete Employee e where e.isPermanent=false";
		try {
			empDeleted = session.createQuery(jpql).executeUpdate();
			transaction.commit();
			msg="Number of Deleted Employee : "+empDeleted;
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}
	
	

}
