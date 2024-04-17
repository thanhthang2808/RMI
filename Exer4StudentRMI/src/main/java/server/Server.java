package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.CourseDAO;
import dao.DepartmentDAO;
import dao.StudentDAO;
import dao.impl.CourseImpl;
import dao.impl.DepartmentImpl;
import dao.impl.StudentImpl;

public class Server {
	private static final String URL = "rmi://ROGStrixG512:7878/";

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			CourseDAO courseDAO = new CourseImpl(); // Java Remote object
			StudentDAO studentDAO = new StudentImpl(); // Java Remote object
			DepartmentDAO departmentDAO = new DepartmentImpl(); // Java Remote object
			
			LocateRegistry.createRegistry(7878);
			context.bind(URL + "departmentDAO", departmentDAO);
			context.bind(URL + "courseDAO", courseDAO);
			context.bind(URL + "studentDAO", studentDAO);
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Server failed to start...");
		}

	}
}
