package hairshop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		list.put("/memberInsert.do", new hairshop.admin.TestController());

		//송현
		
		//린아
		
		//강산
		
		//승연
		
		System.out.println(charset);
	}


	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("service");
		
		req.setCharacterEncoding(charset);
		String uri = req.getRequestURI();					// frontWeb/memberInsert.do
		String contextPath = req.getContextPath();			// frontWeb
		String path = uri.substring(contextPath.length());	// memberInsert.do
		Controller subController = list.get(path);
		subController.execute(req, res);
	}

}
