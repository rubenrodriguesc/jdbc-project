package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department;
		
//		System.out.println("\n=== TEST 1: department insert ====");
//		Department dep = new Department(null, "DP1");
//		departmentDao.insert(dep);
//		System.out.println("Inserted! New id = " + dep.getId());
		
		boolean start = true;
		while (start) {
			System.out.println("===========================================");
			System.out.println("Program Test for DepartmentDaoJDBC");
			System.out.println("Enter the number for execute an option:");
			System.out.println("1 - Insert Department");
			System.out.println("2 - Update Department");
			System.out.println("0 - Exit");
			System.out.print("Option: ");
			int option = sc.nextInt();
			System.out.println("===========================================");
			
			switch (option) {
			case 1:
				System.out.println("-------------------------------------------");
				System.out.println("Inserting new Department");
				System.out.println("-------------------------------------------");
				System.out.print("Name: ");
				String name = sc.next();
				department = new Department(null, name);
				departmentDao.insert(department);
				System.out.println("-------------------------------------------");
				System.out.println("Inserted: "+ department);
				break;
			case 2:
				System.out.println("-------------------------------------------");
				System.out.println("Updating Department");
				System.out.println("-------------------------------------------");
				System.out.print("Enter with Department Id for update: ");
				int id = sc.nextInt();
				System.out.println("-------------------------------------------");
				department = departmentDao.findById(id);
				System.out.println("Department Selected: " + department);
				System.out.println("-------------------------------------------");
				System.out.println("Enter new data:");
				System.out.print("Name: ");
				department.setName(sc.next());
				departmentDao.update(department);
				System.out.println("-------------------------------------------");
				System.out.println("Department Updated! ");
				System.out.println(department);
				System.out.println("-------------------------------------------");
				break;
			case 0:
				System.out.println("Exiting....");
				start = false;
				break;

			default:
				System.out.println("Invalid Option!");
				break;
			}
			
		}
		sc.close();
	}

}