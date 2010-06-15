package example.dao;

import java.util.List;

import example.data.Word;

public interface DictionaryDao {
	/** Add or update the given word. */
	void updateWord(Word word);
	/** @return all words. */
	List getWords();
	/** @return word for the given identifier */
	Word getWord(Integer id);
	/** @return word for the given identifier */
	void deleteWord(Integer id);
	/** @return a random word */
	Word getRandomWord();
}
