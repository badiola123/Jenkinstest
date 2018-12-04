package resources;

import java.util.ListResourceBundle;

public class View_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Header resources
			{"header.appName", "Berrien Web Aplikazioa"},
			{"header.home", "Sarrera"},
			{"header.users", "Erabiltzaile zerrenda"},
			{"header.user", "Erabiltzailea"},
			{"header.news", "Berrien zerrenda"},
			// Languages
			{"language.en", "Ingelesa"},
			{"language.es", "Gaztelera"},
			{"language.eu", "Euskara"},
			// User properties
			{"userProp.userId", "Erabiltzaile IDa"},
			{"userProp.username", "Erabiltzaile izena"},
			{"userProp.password", "Pasahitza"},
			{"userProp.firstName", "Izena"},
			{"userProp.secondName", "Abizena"},
			{"userProp.email", "e-posta"},
			// News properties
			{"newsProp.newsItemId", "Berriaren IDa"},
			{"newsProp.title", "Izenburua"},
			{"newsProp.body", "Edukia"},
			{"newsProp.date", "Data"},
			{"newsProp.lang", "Hizkuntza"},
			{"newsProp.authorId", "Egilearen IDa"},
			// Actions
			{"action.view", "Ikusi"},
			{"action.save", "Gorde"},
			{"action.edit", "Editatu"},
			{"action.delete", "Ezabatu"},
			{"action.login", "Saioa Hasi"},
			{"action.logout", "Saioa Itxi"},
			{"action.register", "Erregistratu"},
			{"action.newNewsItem", "Berria sortu"},
			// Others
			{"general.hi","�Kaixo!"},
	};

}
