package example.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.inject.Inject;

import example.dao.DictionaryDao;
import example.data.Word;
import example.data.WordList;
//The Java class will be hosted at the URI path "/hibernate/Play"
@Path("/play")
@Component
@Scope("request")
public class Play {

	@Inject
	private DictionaryDao dictionaryDao;
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	@Context HttpServletRequest servletRequest;

	protected String scrambled;
	protected int score = 0;
	
	@GET
	@Path("init")
	public Viewable init() {
	   List<Word> words = dictionaryDao.getWords();
	   int numwords = words.size();
	   int random = getRandom(0,numwords-1);
	   Word selectedWord = words.get(random);
	   // store selected word in the session
	   servletRequest.getSession().setAttribute("selectedWord",selectedWord);
	   String scrambled = selectedWord.scrambled();
	   return new Viewable("/pages/Play.jsp",scrambled);
	} 
	
	@GET
	@Path("guess")
	public Viewable guess() {
	   String message = "";
	   return  new Viewable("/pages/PlayResults.jsp",message);
	} 
	
	private static int getRandom(int min, int max) {
		Random rand = new Random(System.currentTimeMillis());
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}
}
