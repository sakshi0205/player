package dao;
import java.util.*;
import bean.Employee;

public interface EmployeeDao {
  public void addEmployee(Employee employee); 
  public List<Employee>getEmployees();
  public void updateEmployee(Integer empId,String city);
  public void deleteEmployee(Integer empId);
  
}
   

