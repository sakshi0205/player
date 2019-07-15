package dao;
import bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
         List<Employee> employeeList=new ArrayList();
         
         @Override
         public void addEmployee(Employee employee)
         
         {
        	 employeeList.add(employee);
         }

		@Override
		public List<Employee> getEmployees() {
			// TODO Auto-generated method stub
			return employeeList;
		}

		@Override
		public void updateEmployee(Integer empId, String city) {
			// TODO Auto-generated method stub
			for(Employee emp:employeeList)
			{
				if(emp.getEmpId().equals(empId))
					emp.setCity(city);
			}
		}

		@Override
		public void deleteEmployee(Integer empid) {
			// TODO Auto-generated method stub
			for(Employee emp:employeeList){
				if(emp.getEmpId().equals(empid))
					employeeList.remove(emp);
				else
					System.out.println("error");
			}
		}

		
         
         
}
