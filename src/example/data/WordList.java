package example.data;

import java.util.ArrayList;
import java.util.List;


public class WordList {
	private String wordListName;
	private List   words;
	
	public WordList() {
		wordListName = "This is a contact List";
		words = new ArrayList<Word>();
	}

	public String getWordListName() {
		return wordListName;
	}

	public void setWordListName(String wordListName) {
		this.wordListName = wordListName;
	}

	public List getWords() {
		return words;
	}

	public void setWords(List words) {
		this.words = words;
	}
	
	
	
}
