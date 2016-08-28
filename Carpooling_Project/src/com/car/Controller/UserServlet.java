package com.car.Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.Model.UserProcessing;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("txtFullName");
		String gender=request.getParameter("rdGender");
		String state=request.getParameter("txtState");
		String city=request.getParameter("txtCity");
		String street=request.getParameter("txtStreet");
		int zip=Integer.parseInt(request.getParameter("txtZipCode"));
		int birth=Integer.parseInt(request.getParameter("txtBirthYear"));
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		UserProcessing user=new UserProcessing();
		System.out.println(name);
		try {
			user.insertUser(name, gender, state, city,street, zip, birth, email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
