package com.example.cruddemo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.cruddemo.Entity.Student;
import com.example.cruddemo.dao.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// System.out.println("hello world");
			createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryByLastname(studentDAO);
			// updateStudent(studentDAO);
			// deletestudent(studentDAO);
			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int rowdeleted = studentDAO.deleteAll();
		System.out.println(rowdeleted);
	}

	private void deletestudent(StudentDAO studentDAO) {
		int studentid = 3;
		studentDAO.delete(studentid);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println(studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to your wish
		myStudent.setFirstname("lol");
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println(myStudent);

	}

	private void queryByLastname(StudentDAO studentDAO) {

		List<Student> theStudent = studentDAO.findByLastname("khadekar");
		for (Student tempstudentlastname : theStudent) {
			System.out.println(tempstudentlastname);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of student
		List<Student> theStudent = studentDAO.findAll();
		// displaylist of student
		for (Student tempStudent : theStudent) {

			System.out.println(tempStudent);
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("create new student object ");

		Student tempStudent = new Student("abhishek", "khadekar", "abhishekkhadekar07@gmail.com");
		Student tempStudent1 = new Student("prathamesh", "kakad", "prathamesh@gmail.com");
		Student tempStudent2 = new Student("prathamesh", "bharad", "barad@gmail.com");

		// save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		// display id of the saved student
		System.out.println(tempStudent.getId());
		System.out.println(tempStudent.getFirstname());

	}

	private void readStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("creating the student");
		Student student_1 = new Student("abhishek", "khadekar", "abhishekkhadekar07@gmail.com");

		// save the student
		System.out.println("saving the element ");
		studentDAO.save(student_1);

		// display id of the saved student
		int id = student_1.getId();
		String Firstname = student_1.getFirstname();
		System.out.println("here the id written down here ");
		System.out.println(id);

		// retrive stundent based in id
		System.out.println("here the id written down here 00");
		System.out.println(id);
		System.out.println(Firstname);
		Student myStudent = studentDAO.findById(id);

		System.out.println(myStudent);

	}
}
