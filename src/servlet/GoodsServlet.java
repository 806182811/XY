package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.GoodsDao;
import entity.GoodsEntity;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet(description = "goods", urlPatterns = { "/goods" })
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsDao dao=new GoodsDao();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String opt=request.getParameter("opt");
		if(opt.equals("quely")){
			quely(request,response);
		}else if(opt.equals("del")){
			del(request,response);
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=dao.del(id);
			//1.获取输出对象
			PrintWriter out=response.getWriter();
			//2.输出
			out.print(b);
			//3.清除缓存
			out.flush();
			//4.关闭
			out.close();
			
		
	}

	private void quely(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<GoodsEntity> list=dao.quely();
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		out.print(gs.toJson(list));
		out.flush();
		out.close();
	}

}
