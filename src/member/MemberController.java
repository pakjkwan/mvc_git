package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.Command;
import global.DispatcherServlet;
import global.Separator;
import sun.rmi.server.Dispatcher;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== member 컨트롤러 진입===");
		Separator.init(request,response);
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = new MemberBean();
		switch (Separator.command.getAction()) {
		case "login":
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			String name = service.login(member);
			System.out.println("name==="+name);
			if (name.equals("")) {
				Separator.command.setPage("login");
				Separator.command.setView();
			} else {
				Separator.command.setDirectory(request.getParameter("directory"));
				member.setName(name);
				request.setAttribute("abc", member);
			}
			break;
		case "regist":break;
		case "update":break;
		case "delete":break;
		case "detail":break;
		case "list":break; // 오늘 하지 말것
		case "logout":break;
		case "count":break;
		case "find_by":break;// 오늘 하지 말것
		default:
			break;
		}
		DispatcherServlet.send(request, response, Separator.command);
	}
	
}
