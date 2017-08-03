package pl.chemik77.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {

	private int customer_id;
	private int store_id;
	private String firstName;
	private String lastName;
	private String email;
	private int address_id;
	private int active;
	private LocalDate createDate;
	private LocalDateTime lastUpdate;

	public Customer() {
	}

	public Customer(int customer_id, int store_id, String firstName, String lastName, String email, int address_id,
			int active) {
		this.customer_id = customer_id;
		this.store_id = store_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.createDate = LocalDate.now();
		this.lastUpdate = LocalDateTime.now();
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
