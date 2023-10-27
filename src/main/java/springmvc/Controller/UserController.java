package springmvc.Controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.Dao.UserDao;
import springmvc.Entity.Notes;
import springmvc.Entity.User;


@Controller
@RequestMapping("/user/")
public class UserController {
	
	
	@Autowired
	private UserDao userdao;
	
	@RequestMapping("/addnotes")
	public String addnotes(HttpSession session, Model m) {
		User us =(User)session.getAttribute("userobj");
		List<Notes> notes = userdao.getNotesbyUser(us);
		m.addAttribute("list", notes);
		return "add_notes";
	}

	@RequestMapping("/viewnotes")
	public String viewnotes() {
		
		return "view_notes";
	}
	
	
	public String updatenotes(@ModelAttribute Notes n, HttpSession session) {
		User us = (User)session.getAttribute("userObj");
		n.setUser(us);
		n.setDate(LocalTime.now().toString());
		userdao.updateNotes(n);
		session.setAttribute("msg", "Notes Update Successfully");
		return"redirect:/user/viewnotes";
	}

	@RequestMapping("/editnotes")
	public String editnotes(@RequestParam("id") int id,Model m) {
		Notes n = userdao.getNotesbyId(id);
		m.addAttribute("notes", n);		
		return "edit_notes";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Sucessfully");
		return "login";
	}
	
	@RequestMapping(path="/savenotes", method = RequestMethod.POST)
	public String savenotes(@ModelAttribute Notes n, HttpSession session) {
		
		User us =(User)session.getAttribute("userobj");
		n.setDate(LocalDateTime.now().toString());
		n.setUser(us);
		userdao.saveNotes(n);
		session.setAttribute("msg", "notes added sucesfully");
		return"redirect:/user/addnotes";
	}
	
	@RequestMapping("/deleteNotes")
	public String deleteNotes(@RequestParam("id") int id, HttpSession session) {
		userdao.deleteNotes(id);
		session.setAttribute("msg", "Notes Delete Successfully");
		return"redirect:/user/viewNotes";
	}
}
