package Erp.service;

import java.util.List;

import Erp.dao.DepartmentDao;
import Erp.dao.EmployeeDao;
import Erp.dao.impl.DepartmentDaoImpl;
import Erp.dao.impl.EmployeeDaoImpl;
import Erp.dto.Department;
import Erp.dto.Employee;

public class DepartmentService {
	private DepartmentDao dao = DepartmentDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();

	public List<Department> showDepartment() {
		return dao.selectDepartmentByAll();
	}

	public void addDepartment(Department department) {
		dao.insertDepartment(department);
	}

	public void removeDepartment(Department dept) {
		dao.deleteDepartment(dept.getDeptno());
	}

	public List<Employee> showEmployeeGroupByDepartment(Department dept) {
		return empDao.selectEmployeeByDept(dept);
	}

	public void modifyDepartment(Department dept) {
		dao.updateDepartment(dept);
	}
	
}
