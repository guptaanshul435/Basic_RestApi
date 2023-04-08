package Ms.India.demoRest;

public class Student {

	
	String stuName;
	String course;
	
	
	public Student(String stuName, String course) {
		super();
		this.stuName = stuName;
		this.course = course;
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public Student() {
		super();
	}
	
}
