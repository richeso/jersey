package example.resources;

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
// The Java class will be hosted at the URI path "/hibernate"
@Path("/")
@Component
@Scope("request")

public class Administer {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	@Context HttpServletRequest servletRequest;

	@Inject private DictionaryDao dictionaryDao;
	@Inject private DictionaryService dictionaryService;
	
	@POST
	@Path("save")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable newWord(
			@FormParam("value")  String value,
			@FormParam("points") String points,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		Word w = new Word(value, new Integer(points));
		dictionaryService.updateWord(w);	
		//servletResponse.sendRedirect("../pages/new_contact.html");
		return  getWordList();
	}
	
	@GET
	@Path("list")
	public Viewable getWordList() {
		List<Word> words = new ArrayList<Word>();
		words.addAll( dictionaryDao.getWords() );
		WordList wlist = new WordList();
		wlist.setWordListName("Word List from jersey service");
		wlist.setWords(words);
			return  new Viewable("/pages/Administer.jsp", wlist);
	} 
	
	@GET
	@Path("delete/{wordKey}/")
	public Viewable delete(
			@PathParam("wordKey") String wordKey,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		dictionaryService.deleteWord(new Integer(wordKey));	
		//servletResponse.sendRedirect("../pages/new_contact.html");
		return  getWordList();
	}
	
	
	
}
