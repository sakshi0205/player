package dao;

import java.util.List;

import bean.EmpLab;



public interface EmpLabDao {

	 public void getEmployee(EmpLab employee); 
	  public List<EmpLab>getEmployees();
	  public void displayEmployee(EmpLab employee);
	  public void getinsuranceScheme(String designation,int salary);
}
