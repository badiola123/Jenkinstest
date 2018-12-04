package domain.news.dao;

import java.util.ArrayList;

import domain.news.dao.DaoNews;
import domain.news.dao.DaoNewsMySQL;
import domain.news.model.News;

public class NewsFacade {

	DaoNews daoNews = null;
	
	public NewsFacade(){
		//login = new DaoLoginProperties();
		daoNews = new DaoNewsMySQL();
	}

	public News loadNews(int newsItemId){
		return daoNews.loadNews(newsItemId);
	}
	
	public ArrayList<News> loadNewsList(){
		return daoNews.loadNewsList();
	}
	public boolean saveNews(News news) {
		boolean ret = false;
		if(news.getNewsItemId()!=null && news.getNewsItemId()!=0)
			ret=daoNews.updateNews(news);
		else
			ret=daoNews.insertNews(news);
		return ret;
	}
	public boolean deleteNews(Integer newsItemId) {
		return daoNews.deleteNews(newsItemId);
		
	}

}