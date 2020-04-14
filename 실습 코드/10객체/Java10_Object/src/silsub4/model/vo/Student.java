package silsub4.model.vo;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	{
		grade = 3;
		classroom = 2;
		name = "이창진";
		height = 199.55;
		gender = '남';
		
	}
	
public Student() {}

public Student(int grade, int classroom, String name, double height, char gender) {
	this.grade = grade;
	this.classroom = classroom;
	this.name = name;
	this.height = height;
	this.gender = gender;
}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
		
	
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	public String info() {
		return grade + ", "+ classroom + ", "+ name + ", "+ height + ", " + gender;
	}
	
	
	
}
