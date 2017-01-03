package com.designpattern.mvc;

public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}

	public String getStudentName() {
		return model.getName();
	}

	public void setStudentName(String name) {
		this.model.setName(name);
	}

	public int getStudentRollno() {
		return model.getRollno();
	}

	public void setRollno(int rollno) {
		this.model.setRollno(rollno);
	}

	public void updateView() {
		view.printStudentDetails(model.getName(), model.getRollno());
	}
}
