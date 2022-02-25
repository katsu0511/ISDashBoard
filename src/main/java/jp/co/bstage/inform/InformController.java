package jp.co.bstage.inform;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(InformController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InformController.class);
    }
    
    @RequestMapping(value = "/add/inform", method = RequestMethod.POST)
	public ModelAndView addInform(@RequestParam String user, @RequestParam String inform) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			try {
				String sender = session.getAttribute("user_id").equals(user) ? user : null;
				jdbcTemplate.update(
					"INSERT INTO INFO (SENDER, INFOCT) VALUES (?, ?)",
					sender, inform
				);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			ModelAndView mav = new ModelAndView("redirect:/top");
			return mav;
		}
	}
    
    @RequestMapping(value = "/inform/{id}", method = RequestMethod.GET)
	public ModelAndView showInform(@PathVariable int id, ModelAndView mav) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			try {
				Map<String, Object> info = new HashMap<>();
				String sql = "SELECT * FROM INFO WHERE INFOID='" + id + "'";
				info = jdbcTemplate.queryForList(sql).get(0);
				mav.setViewName("inform/show");
				mav.addObject("info", info);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
    
    @RequestMapping(value = "/delete/inform", method = RequestMethod.POST)
	public ModelAndView deleteInform(@RequestParam int id, @RequestParam String user) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				try {
					String sender = user;
					jdbcTemplate.update(
						"DELETE FROM INFO WHERE INFOID=? AND SENDER=?",
						id, sender
					);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
    
    @RequestMapping(value = "/edit/inform", method = RequestMethod.POST)
	public ModelAndView editInform(@RequestParam int id, @RequestParam String user, @RequestParam String inform) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				try {
					String sender = user;
					jdbcTemplate.update(
						"UPDATE INFO SET INFOCT=?, UDDTTM=current_timestamp WHERE INFOID=? AND SENDER=?",
						inform, id, sender
					);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/inform/" + id);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
}
