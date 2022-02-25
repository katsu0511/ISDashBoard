package jp.co.bstage.task;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.bstage.bean.Task;

@Controller
public class TaskController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(TaskController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaskController.class);
    }
    
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
	public ModelAndView showTask(@PathVariable int id, ModelAndView mav) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			
			try {
				String user = (String) session.getAttribute("user_id");
				List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
				Task task = new Task();
				tasks = task.getTasks();
				
				Map<String, Object> taskItem = new HashMap<>();
				for (Map<String, Object> item : tasks) {
					if (((Integer)(item.get("TASKID"))).intValue() == id) {
						taskItem = item;
					}
				}
				String sql = "SELECT * FROM PFMC WHERE TASKID=" + id + " ORDER BY PFMCID ASC";
				List<Map<String, Object>> pfmcs = new ArrayList<Map<String, Object>>();
				pfmcs = jdbcTemplate.queryForList(sql);
				
				mav.setViewName("task/show");
				mav.addObject("user", user);
				mav.addObject("task", taskItem);
				mav.addObject("pfmcs", pfmcs);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
    
    @RequestMapping(value = "/add/performance", method = RequestMethod.POST)
	public ModelAndView addPerformance(
			@RequestParam String task_id,
			@RequestParam String date,
			@RequestParam String cost,
			@RequestParam String user,
			@RequestParam String performance) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			try {
				String sender = session.getAttribute("user_id").equals(user) ? user : null;
				jdbcTemplate.update(
					"INSERT INTO PFMC (TASKID, DATETM, PRDTCT, SENDER, PFMCCT) VALUES (?, ?, ?, ?, ?)",
					task_id, date, cost, sender, performance
				);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			ModelAndView mav = new ModelAndView("redirect:/task/" + task_id);
			return mav;
		}
	}
    
    @RequestMapping(value = "/delete/performance", method = RequestMethod.POST)
	public ModelAndView deletePerformance(
			@RequestParam int task_id,
			@RequestParam int pfmc_id,
			@RequestParam String user) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				
				try {
					String sender = user;
					jdbcTemplate.update(
						"DELETE FROM PFMC WHERE TASKID=? AND PFMCID=? AND SENDER=?",
						task_id, pfmc_id, sender
					);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/task/" + task_id);
				return mav;
				
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
    
    @RequestMapping(value = "/edit/performance", method = RequestMethod.POST)
	public ModelAndView editPerformance(
			@RequestParam int task_id,
			@RequestParam int pfmc_id,
			@RequestParam String date,
			@RequestParam String cost,
			@RequestParam String user,
			@RequestParam String performance) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			if (session.getAttribute("user_id").equals(user)) {
				
				try {
					String sender = user;
					jdbcTemplate.update(
						"UPDATE PFMC SET DATETM=?, PRDTCT=?, PFMCCT=?, UDDTTM=current_timestamp WHERE PFMCID=? AND TASKID=? AND SENDER=?",
						date, cost, performance, pfmc_id, task_id, sender
					);
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/task/" + task_id);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
}
