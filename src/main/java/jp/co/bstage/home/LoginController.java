package jp.co.bstage.home;

import java.util.ArrayList;
import java.util.List;
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
public class LoginController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(LoginController.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoginController.class);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView mav) {
		if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			mav.setViewName("home/login");
			return mav;
		} else {
			return new ModelAndView("redirect:/top");
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String user_id, @RequestParam String password, ModelAndView mav) {
		if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			if (user_id.equals("") || password.equals("")) {
				mav.setViewName("home/login");
				mav.addObject("msg", "ユーザーIDとパスワードを入力してください");
				return mav;
			} else {
				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				
				try {
					String sql = "SELECT * FROM USER WHERE USERID='" + user_id + "' AND PASSWD='" + password + "'";
					data = jdbcTemplate.queryForList(sql);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				if (data.isEmpty()) {
					mav.setViewName("home/login");
					mav.addObject("msg", "ユーザーIDかパスワードが間違っています");
					return mav;
				} else {
					session.setAttribute("user_nu", data.get(0).get("USERNU"));
					session.setAttribute("user_id", user_id);
					session.setAttribute("password", password);
					return new ModelAndView("redirect:/top");
				}
			}
		} else {
			return new ModelAndView("redirect:/top");
		}
	}
}
