package dao;

import pojo.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

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

}
