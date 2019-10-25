package com.learn.issuetracker.model;

/*
 * Model class for storing Employee details. Complete the code as per the comments given below
*/
public class Employee {

	private int emplId;
	private String name;
	private String location;

	public Employee() {
		// Default Constructor
	}

	/*
	 * Complete the parameterized Constructor
	 */
	public Employee(int emplId, String name, String location) {

		super();
		this.emplId = emplId;
		this.name = name;
		this.location = location;
	}

	public int getEmplId() {
		return emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee : {Employee Id : "+emplId+"; Name :"+name+"; Location : "+location+"}";
	}

	/*
	 * Override toString() here . The toString() should return the employee details
	 * in the below format
	 * 
	 * Employee : {Employee Id : xxx; Name : xxxx; Location : xxxxx}
	 */

	/*
	 * Complete the Getter and Setters
	 */
	

}