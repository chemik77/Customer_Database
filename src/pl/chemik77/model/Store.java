package pl.chemik77.model;

public class Store {

	private int store_id;
	private String name;
	private String city;

	public Store() {
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + ", city=" + city + "]";
	}

}
