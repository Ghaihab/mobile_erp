package com.example.os;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Employee implements Parcelable {

	public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
		@Override
		public Employee createFromParcel(Parcel source) {
			return new Employee(source);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};
	
	private String employee_id;
	private String ssn;
	private String first_name;
	private String last_name;
	private String date_of_birth;
	private String attendance;
	private String city;
	private String street;
	private String phone_number;
	private String rate;
	private String salary;
	private String sex;
	private String zip_code;
	private String username;
	private String password;

	public Employee() {

		this.employee_id = " ";
		this.ssn = " ";
		this.first_name = " ";
		this.last_name = " ";
		this.date_of_birth = " ";
		this.attendance = " ";
		this.city = " ";
		this.street = " ";
		this.phone_number = " ";
		this.rate = " ";
		this.salary = " ";
		this.sex = " ";
		this.zip_code = " ";
		this.username = " ";
		this.password = " ";

	}

	private Employee(Parcel in){

		this.employee_id = in.readString();
		this.ssn = in.readString();
		this.first_name = in.readString();
		this.last_name = in.readString();
		this.date_of_birth = in.readString();
		this.attendance = in.readString();
		this.city = in.readString();
		this.street = in.readString();
		this.phone_number = in.readString();
		this.rate = in.readString();
		this.salary = in.readString();
		this.sex = in.readString();
		this.zip_code = in.readString();
		this.username = in.readString();
		this.password = in.readString();

	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) { this.employee_id = employee_id; }

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAttendance() { return attendance; }

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZip_code() {
		return this.zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int describeContents() { return 0; }

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(employee_id);
		dest.writeString(ssn);
		dest.writeString(first_name);
		dest.writeString(last_name);
		dest.writeString(date_of_birth);
		dest.writeString(attendance);
		dest.writeString(city);
		dest.writeString(street);
		dest.writeString(phone_number);
		dest.writeString(rate);
		dest.writeString(salary);
		dest.writeString(sex);
		dest.writeString(zip_code);
		dest.writeString(username);
		dest.writeString(password);

	}

}
