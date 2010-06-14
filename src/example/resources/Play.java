package example.resources;

import javax.ws.rs.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import example.dao.DictionaryDao;
import example.data.Word;
//The Java class will be hosted at the URI path "/hibernate/Play"
@Path("/play")
@Component
@Scope("request")
public class Play {

	private DictionaryDao dictionaryDao;
	
	private WordModel model;
	protected String scrambled;
	protected int score = 0;
	
	public Play() { 
		 
	}

	
	
	class WordModel {
		
	}
}
