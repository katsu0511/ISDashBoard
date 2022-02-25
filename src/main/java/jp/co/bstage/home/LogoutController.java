package jp.co.bstage.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController extends SpringBootServletInitializer {
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(LogoutController.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LogoutController.class);
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout() {
		session.invalidate();
		return new ModelAndView("redirect:/login");
	}
}
