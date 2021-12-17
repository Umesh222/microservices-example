package com.umesh.microservices.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="USERS",schema="MICROSERVICES_USERS")
public class User {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UMESH_Sequence")
    @SequenceGenerator(allocationSize = 5000, name="UMESH_Sequence", sequenceName="UMESH_Sequence")
	@Column(name="user_id")
	private Long userId;
	@Column(name="user_name")
	private String name;
	@Column(name="user_email")
	private String email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String name, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
	

}
