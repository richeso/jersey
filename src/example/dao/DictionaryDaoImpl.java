package example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import example.data.Word;

@Repository
public class DictionaryDaoImpl extends HibernateDaoSupport implements DictionaryDao {
	public void updateWord(Word word) {
		getHibernateTemplate().saveOrUpdate(word);
	}
	public List  getWords() {
		List wordList = getHibernateTemplate().find("from Word order by value");
		int numlist = wordList.size();
		System.out.println("Number of entries = "+numlist);
		return getHibernateTemplate().find("from Word order by value");
	}
	public Word getWord(Integer id) {
		return (Word) getHibernateTemplate().get(Word.class, id);
	}
	public Word getRandomWord() {
		return (Word) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Integer count = (Integer) 
					session.createCriteria(Word.class)
						.setProjection(Projections.count("id"))
						.uniqueResult();
				Random rand = new Random(System.currentTimeMillis());
				return session.createCriteria(Word.class)
					.setFirstResult((int) (rand.nextFloat() * count))
					.setMaxResults(1)
					.uniqueResult();
			}
		});
	}
}
