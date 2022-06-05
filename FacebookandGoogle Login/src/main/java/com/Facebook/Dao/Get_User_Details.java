package com.Facebook.Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.Facebook.Model.Users;

public class Get_User_Details {
	public Users call_me(String access_token) throws Exception {
		String url = "https://graph.facebook.com/v14.0/me?fields=id%2Cname%2Cpicture%7Bheight%2Curl%2Cwidth%7D%2Cemail%2Clocation%2Cgender&access_token="
				+ access_token;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response);
		Users obj_user = new Users();
		JSONObject myResponse = new JSONObject(response.toString());
		obj_user.setUser_name(myResponse.getString("name"));
		obj_user.setId(myResponse.getString("id"));
		obj_user.setEmail(myResponse.getString("email"));
		JSONObject picture_reponse = myResponse.getJSONObject("picture");
		JSONObject data_response = picture_reponse.getJSONObject("data");
		System.out.println("URL : " + data_response.getString("url"));
		obj_user.setProfile_picture(data_response.getString("url"));
		JSONObject jsonlocationInfo = myResponse.getJSONObject("location");
		obj_user.setLocation(jsonlocationInfo.getString("id"));
		obj_user.setLocation(jsonlocationInfo.getString("name"));

		obj_user.setGender(myResponse.getString("gender"));
		return obj_user;
	}

}
