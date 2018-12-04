package domain.news.dao;

import java.util.ArrayList;

import domain.news.model.News;

public interface DaoNews {
	public News loadNews(int newsItemId);
	public ArrayList<News> loadNewsList();
	public boolean insertNews(News news);
	public boolean updateNews(News news);
	public boolean deleteNews(int newsItemId);
}

