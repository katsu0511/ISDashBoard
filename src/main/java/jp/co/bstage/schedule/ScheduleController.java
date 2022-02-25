package jp.co.bstage.schedule;

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
public class ScheduleController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(ScheduleController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ScheduleController.class);
    }
    
    @RequestMapping(value = "/add/schedule", method = RequestMethod.POST)
	public ModelAndView addSchedule(
			@RequestParam String start_date,
			@RequestParam String end_date,
			@RequestParam String user,
			@RequestParam String schedule) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			try {
				String sender = session.getAttribute("user_id").equals(user) ? user : null;
				String datetime = start_date + "〜" + end_date;
				jdbcTemplate.update(
					"INSERT INTO SCDL (DATETM, SENDER, SCDLCT) VALUES (?, ?, ?)",
					datetime, sender, schedule
				);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			ModelAndView mav = new ModelAndView("redirect:/top");
			return mav;
		}
	}
    
    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.GET)
	public ModelAndView showSchedule(@PathVariable int id, ModelAndView mav) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			try {
				Map<String, Object> scdl = new HashMap<>();
				String sql = "SELECT * FROM SCDL WHERE SCDLID='" + id + "'";
				scdl = jdbcTemplate.queryForList(sql).get(0);
				
				mav.setViewName("schedule/show");
				mav.addObject("scdl", scdl);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
    
    @RequestMapping(value = "/delete/schedule", method = RequestMethod.POST)
	public ModelAndView deleteSchedule(@RequestParam int id, @RequestParam String user) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				try {
					String sender = user;
					jdbcTemplate.update(
						"DELETE FROM SCDL WHERE SCDLID=? AND SENDER=?",
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
    
    @RequestMapping(value = "/edit/schedule", method = RequestMethod.POST)
	public ModelAndView editSchedule(
			@RequestParam int id,
			@RequestParam String start_date,
			@RequestParam String end_date,
			@RequestParam String user,
			@RequestParam String schedule) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				try {
					String sender = user;
					String datetime = start_date + "〜" + end_date;
					jdbcTemplate.update(
						"UPDATE SCDL SET DATETM=?, SCDLCT=?, UDDTTM=current_timestamp WHERE SCDLID=? AND SENDER=?",
						datetime, schedule, id, sender
					);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/schedule/" + id);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
}
