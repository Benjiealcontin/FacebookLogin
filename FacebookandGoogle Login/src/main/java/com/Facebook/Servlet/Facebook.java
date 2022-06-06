package com.Facebook.Servlet;

import java.io.IOException;

import com.Facebook.Dao.Crud;
import com.Facebook.Dao.Get_User_Details;
import com.Facebook.Model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Facebook
 */
public class Facebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Facebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String access_token = (String) request.getParameter("access_token");

			Get_User_Details obj_Profile_Modal = new Get_User_Details();
			Users user = obj_Profile_Modal.call_me(access_token);
			String id = user.getId();
			String name = user.getUser_name();
			String email = user.getEmail();
			String location = user.getLocation();
			String gender = user.getGender();
			String picture = user.getProfile_picture();

			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("location", location);
			request.setAttribute("gender", gender);
			request.setAttribute("picture", picture);
			request.setAttribute("token", access_token);
			request.getRequestDispatcher("userpage.jsp").forward(request, response);

			Users u = new Users();
			u.setUser_name(name);
			u.setEmail(email);
			u.setLocation(location);
			u.setGender(gender);
			u.setProfile_picture(picture);
			u.setToken(access_token);

			Crud ope = new Crud();

			int i = ope.Adduser(u);

			if (i > 0) {
				response.sendRedirect("userpage.jsp");
			} else {
				response.sendRedirect("Welcomepage.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
