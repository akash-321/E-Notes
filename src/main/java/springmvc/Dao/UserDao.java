package springmvc.Dao;

import java.util.List;

import springmvc.Entity.Notes;
import springmvc.Entity.User;

public interface UserDao {
	
	public int saveUser(User user);
	public User login(String email, String password);
	
//	User Notes Dao
	public int saveNotes(Notes notes);
	public List<Notes> getNotesbyUser(User user);
	public Notes getNotesbyId(int id);
	public void deleteNotes(int id); 
	public void updateNotes(Notes notes);
}
