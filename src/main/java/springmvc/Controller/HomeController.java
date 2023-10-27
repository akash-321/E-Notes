package springmvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import springmvc.Dao.UserDao;
import springmvc.Entity.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userdao;

	@RequestMapping("/home")
	public String home() {
		System.out.println("this is home");
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println("this is login");
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		System.out.println("this is register");
		return "register";
	}

	

	@RequestMapping(path = "/registeruser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, HttpSession session) {
//		System.out.println(user);
		userdao.saveUser(user);
		session.setAttribute("msg", "Registered Succesfully");
		return "redirect:/register";
	}

	@RequestMapping(path = "/loginruser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		
		User user = userdao.login(email,password);
		
		if(user!=null) {
			session.setAttribute("userobj", user);
			return "profile";
		}
		else {
			session.setAttribute("msg", "email and password invalid");
			return"redirect:/login";
		}
	}

}
