package autologin.resources;



import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import autologin.service.ProgrammaticAuthenticator;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.samples.bookstore.resources.Item;
import com.sun.jersey.spi.inject.Inject;

import sample.hello.bean.Address;
import sample.hello.bean.Contact;
import sample.hello.bean.ContactList;
import sample.hello.storage.ContactStore;

import example.dao.DictionaryDao;
import example.dao.DictionaryDaoImpl;
import example.data.Word;
import example.data.WordList;
import example.service.DictionaryService;
import example.service.DictionaryServiceImpl;

@Path("autologin")
public class Login {
	@Context UriInfo uriInfo;
	@Context Request request;
	@Context HttpServletRequest servletRequest;

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(
			@FormParam("j_username")  String username,
			@FormParam("j_password")  String password,
			@Context HttpServletResponse servletResponse
	) throws Exception {
		System.out.println("/autologin web service invoked");
		ProgrammaticAuthenticator auth = new ProgrammaticAuthenticator();
		String[] roles = {"admin","user", "translator"};
		List<String> roleList = new ArrayList <String> ()  ;
		for (String role: roles) {
			roleList.add(role);
		}
		auth.authenticate(servletRequest, servletResponse, username, password, roleList);
		return "SUCCESSFUL LOGIN FROM AUTOLOGIN";
	}
	
	
}
