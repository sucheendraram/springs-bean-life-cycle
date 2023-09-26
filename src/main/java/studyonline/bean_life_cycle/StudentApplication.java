package studyonline.bean_life_cycle;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentApplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentDAO student = context.getBean("student", StudentDAO.class);
		student.getAllStudents();
		System.out.println("Enter the ID of the student");
		int id = scan.nextInt();
		student.getSpecificStudent(id);
		context.close(); //Remove all the objects from the Spring container
	}
}
