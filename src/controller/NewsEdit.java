package controller;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dao.UserFacade;
import domain.user.model.User;
import domain.news.dao.NewsFacade;
import domain.news.model.*;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/NewsEdit")
public class NewsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsEdit() {
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
		NewsFacade nf = new NewsFacade();
		boolean redirect = false;
		
		// Get the user from the session
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get action parameter from request and initialize variables
		String action = request.getParameter("action");
		
		//Get the newsItem ID from the request (newsItemId)
		News newsItem = null;
		int newsItemId = 0;
		String newsItemIdStr = request.getParameter("newsItemId");
		if(newsItemIdStr != null && !newsItemIdStr.equals("")){
			//LOAD NEWSITEM
			newsItemId = Integer.parseInt(newsItemIdStr);
			newsItem = nf.loadNews(newsItemId);
		}
		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){ //Session user and news author must match
		// Perform different actions depending on the request
			switch(action){
			case "add":
				request.setAttribute("newsItem", null);
				dispatchURL="/pages/newsForm.jsp";
				break;
			case "delete":
				if(newsItem!=null && sessionUser==newsItem.getAuthor()){
					nf.deleteNews(newsItemId);
					request.setAttribute("message","general.delete");
					request.setAttribute("newsItemId", null);
					dispatchURL ="/NewsView";
				}else {
					request.setAttribute("error","newsEdit.noUser");
					dispatchURL ="/NewsInfo";
				}
				break;
			case "edit":
				if(newsItem!=null && sessionUser==newsItem.getAuthor()){
					request.setAttribute("newsItem", newsItem);
					dispatchURL="/pages/newsForm.jsp";
				}else{
					request.setAttribute("error","newsEdit.noUser");
					dispatchURL ="/NewsInfo";
				}
				break;
			case "save":
				Locale locale;
				News editNewsItem = new News();
				String newNewsItemId = request.getParameter("newsItemId");
				if(newNewsItemId!=null && !newNewsItemId.equals(""))
					editNewsItem.setNewsItemId(Integer.parseInt(newNewsItemId));
				editNewsItem.setTitle(request.getParameter("title"));
				editNewsItem.setBody(request.getParameter("body"));
				
				/*String localeStr = request.getParameter("lang");
				if(localeStr!=null && !localeStr.equals("")){
					localeStr = localeStr.replace("_","-");
					locale = Locale.forLanguageTag(localeStr);
				}else{
					locale = request.getLocale();
				}
				//Object lang = request.getSession().getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
				editNewsItem.setLang(locale.toString()); //GAXKI DAO BAÑO DA IGUAL*/
				editNewsItem.setLang("eu");
				editNewsItem.setAuthor(sessionUser);
				
				
				if(nf.saveNews(editNewsItem)){
					//request.setAttribute("message", "editUser.successful");
					dispatchURL = "NewsInfo?message=editUser.successful";
				}else{
					//request.setAttribute("error", "newUser.failed");
					dispatchURL = "NewsInfo?error=newUser.failed";
				}
				redirect=true;
				
			default:
			}
		}else{
			request.setAttribute("error", "general.noPermission");
			dispatchURL="/index.jsp";
		}
		if(redirect){
			response.sendRedirect(response.encodeRedirectURL(dispatchURL));
		}else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
