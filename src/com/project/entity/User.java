package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="user_id")
	private int id;

	@NotNull(message="required!")
	@NotBlank(message="Email is required!")
	@Email(message=" Enter a vaild Email!")
	@Size(min=3, message=" atleast 3 digits!")
	@Column(name="user_email")
	private String email;
	
	@NotNull(message="required!")
	@NotBlank(message="password is required!")
	@Size(min=5,message="Password must atleast have 5 digits!")
	@Column(name="user_password")
	private String password;

	@NotNull(message="required!")
	@NotBlank(message="Fullname is required!")
	@Size(min=1,message =" atleast 3 digits!")
	@Column(name="user_fullname")
	private String fullname;
	
	@Column(name="user_phone")
	private String phone;
	
	@NotNull(message="required!")
	@NotBlank(message="required!")
	@Size(min=3,max=3,message="Example: B21")
	@Column(name="user_office")
	private String office;
	
	@Column(name="dept_name")
	@NotNull(message="required!")
	private String dept_name;	
	
	public User (){ 
	}
	
	public User(String email, String password, String fullname, String phone,String office, String dept_name) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.office = office;
		this.dept_name = dept_name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}



	public String getOffice() {
		return office;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", phone="
				+ phone + ", office=" + office + ", dept_name=" + dept_name + "]";
	}
	
	
	
}
