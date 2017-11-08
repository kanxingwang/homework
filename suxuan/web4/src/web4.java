import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web4.dao.UsersDao;
import com.web4.dao.impl.*;
import com.web4.entity.User;

public class web4 extends HttpServlet {
public static final long serialVersionUID = 1L;
	public web4() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		UsersDao ud=new UserDaoimpl();
		String dos=request.getParameter("do");
		if(dos==null||dos.equals("")){
			dos="index";
		}
	//主页
		if(dos.equals("index")){
			List<User> list=ud.getAlluser();
			session.setAttribute("list", list);
			response.sendRedirect("index.jsp");
			return;
		}
		if(dos.equals("add")){
			String userid=request.getParameter("ids");
		    int ids=Integer.parseInt(userid);
			
			String username=request.getParameter("name");
			String password=request.getParameter("password1");
			String email=request.getParameter("email1");
			String grade=request.getParameter("grade1");
			int grade1=Integer.parseInt(grade);
			User u=new User(0,username,password,email,grade1);
			ud.addUser(u);
			out.print("<script>alert('删除成功!');window.location='servletusers?do=index';</script>");
			return;
			
		}
		if(dos.equals("editbefore")){
			String ids=request.getParameter("id");
			int userid=Integer.parseInt(ids);
			User u=ud.findUserByid(userid);
			session.setAttribute("editusr", u);
			response.sendRedirect("edit.jsp");
			return;
		}
		if(dos.equals("edit")){
			String userid=request.getParameter("ids");
		    int ids=Integer.parseInt(userid);
			String username=request.getParameter("name");
			String password=request.getParameter("password1");
			String email=request.getParameter("email1");
			String grade=request.getParameter("grade1");
			int grade1=Integer.parseInt(grade);
			User u=new User(ids,username,password,email,grade1);
			ud.updateUser(u);
			out.print("<script>alert('修改成功!');window.location='servletusers?do=index';</script>");
			return;
		}

	}


	public void init() throws ServletException {
		// Put your code here
	}

}
