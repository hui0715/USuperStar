package com.zjut.azure;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class typeChange
 */
@WebServlet("/typeChange")
public class typeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public typeChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TypeDao typeDao=new TypeDao();
		Type type=new Type();
		
		ArrayList<Type> typelist=typeDao.findType();
		request.setCharacterEncoding("UTF-8");
		request.getParameter("type");
		int i=Integer.parseInt(request.getParameter("change"));
		type.setType(request.getParameter("type").trim());
		type.setBed(request.getParameter("bed").trim());
		type.setCapability(Integer.parseInt(request.getParameter("capability").trim()));
		type.setWifi(Boolean.parseBoolean(request.getParameter("WIFI").trim()));
		type.setRoomsize(Integer.parseInt(request.getParameter("roomsize").trim()));
		type.setPrice(Float.parseFloat(request.getParameter("price").trim()));
		boolean flag=typeDao.changeType(type, typelist.get(i).getType());
		if(flag) {
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/typeSetting");
			requestDispatcher.forward(request, response);
		}
	}

}
