package jp.co.bstage.personal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(PersonalController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PersonalController.class);
    }
    
    @RequestMapping("/personal")
	public ModelAndView personal(ModelAndView mav) {
		if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			try {
				String user_id = (String) session.getAttribute("user_id");
				String password = (String) session.getAttribute("password");
				Map<String, Object> user = new HashMap<>();
				
				String sql = "SELECT * FROM USER WHERE USERID='" + session.getAttribute("user_id") + "' AND PASSWD='" + session.getAttribute("password") + "'";
				user = jdbcTemplate.queryForList(sql).get(0);
				
				mav.setViewName("personal/show");
				mav.addObject("user_id", user_id);
				mav.addObject("password", password);
				mav.addObject("user", user);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
    
    @RequestMapping(value = "/edit/password", method = RequestMethod.POST)
	public ModelAndView editPassword(
			@RequestParam String user_id,
			@RequestParam String password,
			@RequestParam String password2) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user_id)) {
				try {
					String user = user_id;
					jdbcTemplate.update(
						"UPDATE USER SET PASSWD=? WHERE USERID=? AND PASSWD=?",
						password2, user, password
					);
					session.setAttribute("password", password2);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/personal");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
}
