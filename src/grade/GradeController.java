package grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.DispatcherServlet;
import global.Separator;
import member.MemberService;
import member.MemberServiceImpl;

@WebServlet("/grade.do")

public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=== grade 컨트롤러 진입 ===");
		Separator.init(request, response);
		switch (Separator.command.getAction()) {
		case "":
			
			break;

		default:
			break;
		}
	DispatcherServlet.send(request, response, Separator.command);
	}
	
}