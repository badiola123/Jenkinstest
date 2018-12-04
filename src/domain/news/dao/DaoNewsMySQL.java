package domain.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import config.MySQLConfig;
import domain.news.model.News;
import domain.user.dao.DaoUserMySQL;
import domain.user.model.User;
public class DaoNewsMySQL implements DaoNews{

	@Override
	public News loadNews(int newsItemId) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		News newsItem = null;
		ResultSet rs = null;
		User author=null;
		int authorId=0;
		
		String sqlQuery = "SELECT * FROM news_item "
				+ "WHERE newsItemId="+newsItemId;
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				newsItem = new News();
				
				newsItem.setNewsItemId(rs.getInt("newsItemId"));
				newsItem.setTitle(rs.getString("title"));
				newsItem.setBody(rs.getString("body"));
				Timestamp timestamp=rs.getTimestamp("date");
				Date date= timestamp;
				newsItem.setDate(date);
				newsItem.setLang(rs.getString("lang"));
				authorId=rs.getInt("authorId");
				author=new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsMysql exists select");
		}
		
		MySQLConfig.disconnect(connection,stm);
		return newsItem;
	}

	@Override
	public ArrayList<News> loadNewsList() {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		ArrayList<News> newsItemList = new ArrayList<News>();
		News newsItem = null;
		ResultSet rs = null;
		User author=null;
		int authorId=0;
		
		String sqlQuery = "SELECT * FROM news_item";
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				newsItem = new News();
				
				newsItem.setNewsItemId(rs.getInt("newsItemId"));
				newsItem.setTitle(rs.getString("title"));
				newsItem.setBody(rs.getString("body"));
				Timestamp timestamp=rs.getTimestamp("date");
				Date date= new Date(timestamp.getTime());
				newsItem.setDate(date);
				newsItem.setLang(rs.getString("lang"));
				authorId=rs.getInt("authorId");
				author=new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);
				newsItemList.add(newsItem);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsMySQL loadUsers select");
		}
		
		MySQLConfig.disconnect(connection,stm);
		return newsItemList;
	}

	@Override
	public boolean insertNews(News news) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "INSERT INTO news_item (newsItemId,title,body,date,lang,authorId) "+
		"VALUES("
		+ "'"+news.getNewsItemId()+"',"
		+ "'"+news.getTitle()+"',"
		+ "'"+news.getBody()+"',"
		+ "'"+news.getDate()+"',"
		+ "'"+news.getLang()+"'"
		+ "'"+news.getAuthor().getUserId()+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
	}

	@Override
	public boolean updateNews(News news) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "UPDATE news_item "+
		"SET "
		+ "title='"+news.getTitle()+"',"
		+ "body='"+news.getBody()+"',"
		+ "date='"+news.getDate()+"',"
		+ "lang='"+news.getLang()+"',"
		+ "authorId='"+news.getAuthor().getUserId()+"'"
		+ "WHERE userId="+news.getNewsItemId();
		System.out.println(sqlQuery);

		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
	}

	@Override
	public boolean deleteNews(int newsItemId) {
		Connection connection = MySQLConfig.connect();
		Statement stm = null;
		boolean ret = false;
		
		String sqlQuery = "DELETE FROM news_item WHERE newsItemId="+newsItemId;
		System.out.println(sqlQuery);

		try{
			stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		MySQLConfig.disconnect(connection,stm);
		return ret;
	}

	
}
