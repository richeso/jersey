package example.service;

import example.data.Word;

public interface DictionaryService {
	void updateWord(Word word);
	void deleteWord(Integer wordKey);
	Word getWord(Integer wordKey);
}
