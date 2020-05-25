package comm;

public class Human {

		protected String name;
		protected int age;
		protected int height;
		protected int weight;
		
		
		
public Human() {}

public Human(String name, int age, int height, int weight) {
	this.name = name;
	this.age = age;
	this.height = height;
	this.weight = weight;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}



public String printInformation() {
	return "이름 : "+name+", 나이 : "+age+", 키 : "+height+", 몸무게 : "+weight;
}


}
