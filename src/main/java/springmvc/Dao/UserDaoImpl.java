package springmvc.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springmvc.Entity.Notes;
import springmvc.Entity.User;


@Transactional
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	@Override
	public int saveUser(User user) {
		int i  = (Integer)hibernatetemplate.save(user);
		return i;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public User login(String email, String password) {
		String sql ="from User where email=:em and password=:pwd";
		
			User user = (User) hibernatetemplate.execute(s -> {
				Query q  = s.createQuery(sql);
				q.setString("em", email);
				q.setString("pwd", password);
				return q.uniqueResult(); 
			});
		return user;
	}

	@Override
	public int saveNotes(Notes notes) {
		int i =(int)hibernatetemplate.save(notes);
		return i;
	}

	@Override
	public List<Notes> getNotesbyUser(User user) {
		String sql = "from Notes where user=:us"; 
		
		List<Notes> list = hibernatetemplate.execute(s -> {
			Query q = s.createQuery(sql); 
			q.setEntity("us", user);
			return q.getResultList();
		});
		return null;
	}

	@Override
	public Notes getNotesbyId(int id) {
		Notes n =hibernatetemplate.get(Notes.class, id);
		return n;
	}

	@Override
	public void deleteNotes(int id) {
		Notes n =hibernatetemplate.get(Notes.class, id);
		hibernatetemplate.delete(n);
		
	}

	@Override
	public void updateNotes(Notes notes) {
		
		hibernatetemplate.update(notes);
		
	}

}
