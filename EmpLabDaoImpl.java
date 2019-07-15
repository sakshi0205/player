package dao;

import java.util.ArrayList;
import java.util.List;

import bean.EmpLab;
import bean.Employee;

public class EmpLabDaoImpl implements EmpLabDao{
	
	List<EmpLab> employeeList=new ArrayList();

	@Override
	public void getEmployee(EmpLab employee) {
		// TODO Auto-generated method stub
		employeeList.add(employee);
		
	}

	@Override
	public List<EmpLab> getEmployees() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public void displayEmployee(EmpLab employee) {
		// TODO Auto-generated method stub
		employeeList.add(employee);
	}

	@Override
	public void getinsuranceScheme(String designation, int salary) {
		// TODO Auto-generated method stub
		
	}
	
	

}
