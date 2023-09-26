package studyonline.bean_life_cycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean(name = { "student", "studentDAO", "s1" }, initMethod = "createConnectionToStudentTable", destroyMethod = "closeConnection")
	public StudentDAO studentBean() {
		StudentDAO student = new StudentDAO();
		student.setUrl("jdbc:mysql://localhost:3306/studyonline?useSSL=false");
		student.setUserName("root");
		student.setPassword("StudyOnlineJava@2023");
		return student;
	}
}
