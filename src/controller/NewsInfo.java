package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.news.dao.NewsFacade;
import domain.user.dao.UserFacade;
import domain.user.model.User;
import domain.news.model.News;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/NewsInfo")
public class NewsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// Set charset for request
		response.setCharacterEncoding("UTF-8");// Set charset for response
		String dispatchURL = "/index.jsp";
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get parameters from request and initialize variables
		//String action = request.getParameter("action");
		String newsItemIdstr = request.getParameter("newsItemId"); 
		int newsItemId = 0;
		News newsItem = null;
		NewsFacade nf = new NewsFacade();

		if(newsItemIdstr != null && !newsItemIdstr.equals("")){//NewsItem selected
			newsItemId = Integer.parseInt(newsItemIdstr);
			newsItem = nf.loadNews(newsItemId);  //load new selected
		}
		if(newsItem != null){
			// Show info about selected newsItem
			request.setAttribute("newsItem", newsItem);
			dispatchURL="/pages/newsView.jsp";
		}else{
			// Show news list
			System.out.println("SHOW NEWS LIST");
			ArrayList<News> newsList = nf.loadNewsList();
			System.out.println("Size:" +newsList.size());
			News n = newsList.get(0);		
			System.out.println(n.getNewsItemId()+n.getTitle());
			request.setAttribute("news", newsList);
			dispatchURL="/pages/newsList.jsp";
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
