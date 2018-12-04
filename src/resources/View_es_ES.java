package resources;

import java.util.ListResourceBundle;

public class View_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Header resources
			{"header.appName", "Aplicaci�n Web de Noticias"},
			{"header.home", "Inicio"},
			{"header.users", "Usuarios"},
			{"header.user", "Usuario"},
			{"header.news", "Noticias"},
			// Languages
			{"language.en", "Ingl�s"},
			{"language.es", "Castellano"},
			{"language.eu", "Vasco"},
			// User properties
			{"userProp.userId", "ID de usuario"},
			{"userProp.username", "Nombre de usuario"},
			{"userProp.password", "Contrase�a"},
			{"userProp.firstName", "Nombre"},
			{"userProp.secondName", "Apellido"},
			{"userProp.email", "Correo electr�nico"},
			// News properties
			{"newsProp.newsItemId", "ID de noticia"},
			{"newsProp.title", "T�tulo"},
			{"newsProp.body", "Contenido"},
			{"newsProp.date", "Fecha"},
			{"newsProp.lang", "Idioma"},
			{"newsProp.authorId", "ID de autor"},
			// Actions
			{"action.view", "Ver"},
			{"action.save", "Guardar"},
			{"action.edit", "Editar"},
			{"action.delete", "Eliminar"},
			{"action.login", "Iniciar session"},
			{"action.logout", "Cerrar session"},
			{"action.register", "Registrar"},
			{"action.newNewsItem", "Crear noticia"},
			// Others
			{"general.hi","�Hola!"},
	};

}
