package com.designpattern.mvc;

public class MVCTest {
	public static void main(String[] args) {
		Student model = fetchStudentFromDB();

		StudentView view = new StudentView();

		StudentController controller = new StudentController(model, view);

		controller.updateView();
		System.out.println();

		controller.setStudentName("David");
		controller.updateView();
	}

	private static Student fetchStudentFromDB() {
		Student student = new Student();
		student.setName("John");
		student.setRollno(5);
		return student;
	}
}
