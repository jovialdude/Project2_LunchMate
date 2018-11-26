package com.revature.models;


import java.sql.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;






@Component
//	@Entity
//	@Table(name="Users")
public class User	{

//	@Column(name="User_ID")
@Id
//@NotNull
private int userId;

//	not sure how a phone number would be validated
//	@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
private String phoneNumber;

//	is FB providing this?
//	@Email
//	@Column(unique=true)
private String email;

private String FaceBookId;

private String FaceBookToken;

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(int userId, String phoneNumber, String email, String faceBookId, String faceBookToken) {
	super();
	this.userId = userId;
	this.phoneNumber = phoneNumber;
	this.email = email;
	FaceBookId = faceBookId;
	FaceBookToken = faceBookToken;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFaceBookId() {
	return FaceBookId;
}

public void setFaceBookId(String faceBookId) {
	FaceBookId = faceBookId;
}

public String getFaceBookToken() {
	return FaceBookToken;
}

public void setFaceBookToken(String faceBookToken) {
	FaceBookToken = faceBookToken;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", phoneNumber=" + phoneNumber + ", email=" + email + ", FaceBookId=" + FaceBookId
			+ ", FaceBookToken=" + FaceBookToken + "]";
}




}
