package com.unitbv.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unitbv.entities.Person;
import com.unitbv.impl.App;


public class PersonView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5093822362487997465L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Person person = new Person();
		person.setName(name);
		person.setEmail(email);

		App repo = new App("lab1");

		person = repo.createOrUpdate(person);		
		request.setAttribute("id", person.getId());
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
