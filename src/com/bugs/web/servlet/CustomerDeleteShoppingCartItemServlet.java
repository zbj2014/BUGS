package com.bugs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bugs.domain.ShoppingCart;
import com.bugs.domain.order;
import com.bugs.service.OrderService;
import com.bugs.service.ShoppingCartService;

public class CustomerDeleteShoppingCartItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerDeleteShoppingCartItemServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		ShoppingCartService shoppingCartService = new ShoppingCartService();
		if (action.equals("deid")) {
			int shoppingCartItemId = Integer.parseInt(request.getParameter("shoppingCartItemId"));
			
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setId(shoppingCartItemId);
			
			try {
				shoppingCartService.DeleteShoppingCartItem(shoppingCart);
				response.sendRedirect("viewMyCartServlet");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (action.equals("batch")) {
			String ids =  request.getParameter("ids");
			String[] idArray= ids.split(",");
			//
			try {
				shoppingCartService.DeleteShoppingCartItemByBatch(idArray);
				response.sendRedirect("viewMyCartServlet");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
