package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.DispatcherServlet;
import global.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== member 컨트롤러 진입===");
		HttpSession session = request.getSession();
		Separator.init(request,response);
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = new MemberBean();
		System.out.println("액션 ? "+Separator.command.getAction());
		switch (Separator.command.getAction()) {
		case "move":
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "detail":
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "login":
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member = service.login(member);
			if(member.getId().equals("fail")){
				System.out.println("컨트롤러 : 로그인실패");
				Separator.command.setPage("login");
				Separator.command.setView();
			}else{
				System.out.println("컨트롤러 : 로그인성공");
				request.setAttribute("user", member);
				session.setAttribute("user", member);
				Separator.command.setDirectory("global");
				Separator.command.setView();
			}
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "regist":
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setGenderAndBirth(request.getParameter("ssn"));
			member.setRegDate();
			member.setPhone(request.getParameter("phone"));
			member.setEmail(request.getParameter("email"));
			if (service.regist(member).equals("fail")) {
				System.out.println("컨트롤러 : 회원가입 실패");
				Separator.command.setPage("regist");
				Separator.command.setView();
			} else {
				System.out.println("컨트롤러 : 회원가입 성공");
				Separator.command.setPage("login");
				Separator.command.setView();
			}
			DispatcherServlet.send(request, response, Separator.command);
			break;
		
		case "update":
			member = (MemberBean) session.getAttribute("user");
			member.setEmail(request.getParameter("email"));
			member.setPw(request.getParameter("pw"));
			service.update(member);
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "delete":
			service.delete(member);
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "logout":
			service.logout(member);
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "list":
			service.list();
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "find_by":
			service.findBy(request.getParameter("keyword"));
			DispatcherServlet.send(request, response, Separator.command);
			break;
		case "count":
			service.count();
			DispatcherServlet.send(request, response, Separator.command);
			break;
		default:
			break;
		}
		
	}
	
}
