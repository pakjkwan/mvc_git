package bank;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.DispatcherServlet;
import global.Separator;
/*
<li><a href="${context}/account/regist.do">개설</a></li>
		<li><a href="${context}/account/deposit.do">입금</a></li>
		<li><a href="${context}/account/withdraw.do">출금</a></li>
		<li><a href="${context}/account/update.do">비번수정 </a></li>
		<li><a href="${context}/account/delete.do">해지</a></li>
		<li><a href="${context}/account/list.do">목록 </a></li>
		<li><a href="${context}/account/search.do">조회 </a></li>
		<li><a href="${context}/account/count.do">
 * */
@WebServlet("/account.do")

public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DispatcherServlet.send(request, response, Separator.init(request, response));
	}
	

}
