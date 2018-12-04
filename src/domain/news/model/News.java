package domain.news.model;

import java.util.Date;

import domain.user.model.User;

public class News implements java.io.Serializable /*2nd characteristic*/{
	private static final long serialVersionUID = 3834633934831160740L;
	
	// 3rd characteristic: multiple properties.
	private int newsItemId = 0;
	private String title = null;
	private String body = null;
	private Date date = null;
	private String lang = null;
	private User author = null;
	


	public News(){
		
	}// 1st characteristic
	
	public Integer getNewsItemId() {
		return newsItemId;
	}

	public void setNewsItemId(int newsItemId) {
		this.newsItemId = newsItemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}



	
}