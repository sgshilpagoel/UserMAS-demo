package com.java.demo.entity;
import javax.persistence.*;
@Entity
@Table(name = "User")
public class User {
	@Column(name = "id")
	int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Column(name = "name")
     String name;
	
	@Id
	@Column(name = "username")
    String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "email")
     String email;
	@Column(name = "password")
    String password;	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Column(name = "lastLogin")
    String lastLogin;
	
public User(){
        super();
    }

public User(String username,String password){
    super();
    this.username = username;
    this.password = password;
}

public User(int id, String name, String email,String password,String lastLogin,String username) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

}