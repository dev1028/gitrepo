package com.yedam.hairshop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.hairshop.admin.TestController;
<<<<<<< HEAD
import com.yedam.hairshop.members.MembersLoginController;
=======
import com.yedam.hairshop.hairshop.hairshopMainCtrl;
>>>>>>> branch 'master' of https://github.com/dev1028/gitrepo.git

/*
@WebServlet(name = "front", 
			urlPatterns = "*.do", 
			initParams = {
					@WebInitParam(name = "charset", value="UTF-8")
			})
*/
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		
		//상민
<<<<<<< HEAD
		list.put("/membersInsert.do", new TestController());

=======
		list.put("/memberInsert.do", new TestController());
		list.put("/testDB.do", new TestDBController());
		
>>>>>>> branch 'master' of https://github.com/dev1028/gitrepo.git
		//송현
		
		//린아
		list.put("/membersLogin.do", new MembersLoginController());
		
		//강산
		
		//승연
		list.put("/hairshopMain.do", new hairshopMainCtrl());
		
		
	}


	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("service");
		req.setCharacterEncoding(charset);
		res.setContentType("text/html; charset=UTF-8");
		String uri = req.getRequestURI();					// frontWeb/memberInsert.do
		String contextPath = req.getContextPath();			// frontWeb
		String path = uri.substring(contextPath.length());	// memberInsert.do
		Controller subController = list.get(path);
		
		if(subController == null) {
			System.out.println("잘못된 URL: " + path);
		}else {
			subController.execute(req, res);
		}
	}

}
