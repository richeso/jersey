package example.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.inject.Inject;

import example.dao.DictionaryDao;
import example.data.PlayResults;
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
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable init() {
	   List<Word> words = dictionaryDao.getWords();
	   int numwords = words.size();
	   int random = getRandom(0,numwords-1);
	   Word selectedWord = words.get(random);
	   PlayResults playResults = new PlayResults(selectedWord);
	   // store selected word in the session
	   servletRequest.getSession().setAttribute("playResults",playResults);
	   return new Viewable("/pages/Play.jsp",playResults);
	} 
	@GET
	@Path("again")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable play_again() {
	   List<Word> words = dictionaryDao.getWords();
	   int numwords = words.size();
	   int random = getRandom(0,numwords-1);
	   Word selectedWord = words.get(random);
	   // retrieve selected word in the session
	   PlayResults playResults = (PlayResults)
	   servletRequest.getSession().getAttribute("playResults");
	   // if no session data - go back to init
	   if (playResults == null)
		   return init();
	   
	   playResults.setSelectedWord(selectedWord);
	   servletRequest.getSession().setAttribute("playResults",playResults);
	   return new Viewable("/pages/Play.jsp",playResults);
	} 
	
	@POST
	@Path("guess")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable guess(
			@FormParam("guess")  String guess,
			@Context HttpServletResponse servletResponse) {
		
		 // retrieve selected word in the session
	   PlayResults playResults = (PlayResults)
	   servletRequest.getSession().getAttribute("playResults");
	   if (guess != null && (guess.trim().equals(playResults.getSelectedWord().getValue().trim()))) {
		   playResults.correct();
	   } else {
		   playResults.wrong();   
	   }
	   return  new Viewable("/pages/PlayResults.jsp",playResults);
	}
	
	private static int getRandom(int min, int max) {
		Random rand = new Random(System.currentTimeMillis());
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}
}
