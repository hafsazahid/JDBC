package com.fis.app.test;


public class TestRunnerClass {

	public static void main(String[] args) {
		
		try {
			
			// Animal a = new Dog();
			IEmployeeDAO dao = new EmployeeDAOImpl();
			/*
			Employee mockEmployee = new Employee("test-name",103, 100);
			
			boolean a = dao.addEmployee(mockEmployee);
			System.out.println(a);
			*/
			
			/*
			List<Employee> list = dao.getAllEmployees();
			
			list.stream().forEach((emp)->System.out.println(emp));
			*/
			
			Employee e = dao.getEmployeeBasedOnID(1114);
			System.out.println(e);
			
			
		} catch (Exception e) {
			System.out.println(" Problem "+e);
		}
	}
}
