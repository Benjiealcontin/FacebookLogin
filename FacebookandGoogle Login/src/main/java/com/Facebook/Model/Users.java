package com.Facebook.Model;

public class Users {
	private int ID;
	private String user_name;
	private String email;
	private String profile_picture;
	private String id;
	private String location;
	private String gender;
	private String Token;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int iD, String user_name, String email, String profile_picture, String id2, String location,
			String gender, String token) {
		super();
		ID = iD;
		this.user_name = user_name;
		this.email = email;
		this.profile_picture = profile_picture;
		id = id2;
		this.location = location;
		this.gender = gender;
		Token = token;
	}

	public Users(String user_name, String email, String profile_picture, String id, String location, String gender,
			String token) {
		super();
		this.user_name = user_name;
		this.email = email;
		this.profile_picture = profile_picture;
		this.id = id;
		this.location = location;
		this.gender = gender;
		Token = token;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

}
