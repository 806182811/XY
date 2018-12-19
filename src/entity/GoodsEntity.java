package entity;

public class GoodsEntity {
	int number;
	String name;
	String date;
	String address;
	String types;
	String prices;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public GoodsEntity(int  number, String name, String date, String address,
			String types, String prices) {
		super();
		this.number = number;
		this.name = name;
		this.date = date;
		this.address = address;
		this.types = types;
		this.prices = prices;
	}
	
	
}
