package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department;
		
	
		boolean start = true;
		while (start) {
			System.out.println("===========================================");
			System.out.println("Program Test for DepartmentDaoJDBC");
			System.out.println("Enter the number for execute an option:");
			System.out.println("1 - Insert Department");
			System.out.println("2 - Update Department");
			System.out.println("3 - Delete Department");
			System.out.println("4 - Find By Id Department");
			System.out.println("5 - Find All Department");
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
			case 3:
				System.out.println("-------------------------------------------");
				System.out.println("Deleting Department");
				System.out.println("-------------------------------------------");
				System.out.print("Enter with Department Id to delete: ");
				id = sc.nextInt();
				System.out.println("-------------------------------------------");
				departmentDao.deleteById(id);
				System.out.println("Delete completed!");
				System.out.println("-------------------------------------------");
				break;
			case 4:
				System.out.println("-------------------------------------------");
				System.out.println("Finding Department by Id");
				System.out.println("-------------------------------------------");
				System.out.print("Enter with Department Id: ");
				id = sc.nextInt();
				System.out.println("-------------------------------------------");
				department = departmentDao.findById(id);
				System.out.println(department);
				System.out.println("-------------------------------------------");
				break;
			case 5:
				System.out.println("-------------------------------------------");
				System.out.println("Finding All Departments");
				System.out.println("-------------------------------------------");
				List<Department> list = departmentDao.findAll();
				for (Department dep : list) {
					System.out.println(dep);
				}
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
