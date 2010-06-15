package example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.dao.DictionaryDao;
import example.dao.DictionaryDaoImpl;
import example.data.Word;

@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
	private DictionaryDao dictionaryDao;
	
	public void updateWord(Word word) {
		dictionaryDao.updateWord(word);
	}

	@Autowired
	public void setDictionaryDao(DictionaryDaoImpl dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
	public void deleteWord(Integer wordKey) {
		dictionaryDao.deleteWord(wordKey);
	}
	public Word getWord(Integer wordKey) {
		return dictionaryDao.getWord(wordKey);
	}
}
