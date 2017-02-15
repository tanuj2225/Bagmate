package com.uncc.onlinebaggagefinder.model;

public class User {
String firstName,lastName,email,address,password,country_code,phone_no,passport_no,image_url;
String statusMsg;

public String getStatusMsg() {
	return statusMsg;
}

public void setStatusMsg(String statusMsg) {
	this.statusMsg = statusMsg;
}

public String getImage_url() {
	return image_url;
}

public void setImage_url(String image_url) {
	this.image_url = image_url;
}

public String getFirstName() {
	return firstName;
}

public String getPassport_no() {
	return passport_no;
}

public void setPassport_no(String passport_no) {
	this.passport_no = passport_no;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCountry_code() {
	return country_code;
}

public void setCountry_code(String country_code) {
	this.country_code = country_code;
}

public String getPhone_no() {
	return phone_no;
}

public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}



public User(String firstName, String lastName, String email, String address,
		String password, String country_code, String phone_no,
		String passport_no) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.address = address;
	this.password = password;
	this.country_code = country_code;
	this.phone_no = phone_no;
	this.passport_no = passport_no;
}

@Override
public String toString() {
	return "user [firstName=" + firstName + ", lastName=" + lastName
			+ ", email=" + email + ", address=" + address + ", password="
			+ password + ", country_code=" + country_code + ", phone_no="
			+ phone_no + ", passport_no=" + passport_no + ", image_url="
			+ image_url + "]";
}

public User() {
	
}

}
