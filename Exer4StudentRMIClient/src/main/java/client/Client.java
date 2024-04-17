package client;

import java.rmi.Naming;

import dao.CourseDAO;
import dao.DepartmentDAO;
import dao.StudentDAO;

public class Client {
	
	private static final String URL = "rmi://ROGStrixG512:7878/";
	public static void main(String[] args) {
		try {
			CourseDAO courseDAO = (CourseDAO) Naming.lookup(URL + "courseDAO");
			StudentDAO studentDAO = (StudentDAO) Naming.lookup(URL + "studentDAO");
			DepartmentDAO departmentDAO = (DepartmentDAO) Naming.lookup(URL + "departmentDAO");
			
			
			studentDAO.findAll().forEach(System.out::println);
			courseDAO.findBytitle("Chemistry").forEach(System.out::println);
			departmentDAO.findDepartmentNotOwnerCourse().forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
