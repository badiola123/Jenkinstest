package resources;

import java.util.ListResourceBundle;

/*
 * This is the default resource, in this case English
 * If a resource is not found in other classes,
 * or a non supported language is set,  
 * this class will be used (see footer as example).
 */
public class View extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Footer
			/* As this file is the default one and no translation is needed,
			 * the following 2 parameters are defined just in this file.
			 */
			{"footer.copyright", "Copyleft"},
			{"footer.name", "Alain Perez"},
			// Header resources
			{"header.appName", "News Web App"},
			{"header.home", "Home"},
			{"header.users", "Users"},
			{"header.user", "User"},
			{"header.news", "News"},
			// Languages
			{"language.en", "English"},
			{"language.es", "Spanish"},
			{"language.eu", "Basque"},
			// User Form
			{"userForm.register",""},
			{"userForm.new",""},
			// User properties
			{"userProp.userId", "User ID"},
			{"userProp.username", "Username"},
			{"userProp.password", "Password"},
			{"userProp.firstName", "First Name"},
			{"userProp.secondName", "Second Name"},
			{"userProp.email", "e-mail"},
			// News properties
			{"newsProp.newsItemId", "News ID"},
			{"newsProp.title", "Title"},
			{"newsProp.body", "Body"},
			{"newsProp.date", "Date"},
			{"newsProp.lang", "Language"},
			{"newsProp.authorId", "Author ID"},
			// Actions
			{"action.view", "View"},
			{"action.save", "Save"},
			{"action.edit", "Edit"},
			{"action.delete", "Delete"},
			{"action.login", "Login"},
			{"action.logout", "Logout"},
			{"action.register", "Register"},
			{"action.newNewsItem", "Create News Item"},
			// Others
			{"general.hi","Hi"},
	};

}
