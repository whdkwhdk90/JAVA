package silsub2.model.vo;

public class Product {

	private String pName;
	private int price;
	private String brand;
	
	
	public Product(){}
	
	Product(String pName, int price, String brand){
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}
	
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	public String info() {
		return pName + ", "+ price + ", "+ brand;
	}
	
	
	
}
