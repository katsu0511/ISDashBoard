package jp.co.bstage.setting;

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
public class SettingController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(SettingController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SettingController.class);
    }
    
    @RequestMapping("/setting")
	public ModelAndView setting(ModelAndView mav) {
		if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			
			try {
				String user_nu = ((Integer)session.getAttribute("user_nu")).toString();
				String sql = "SELECT * FROM STNG WHERE USERNU='" + user_nu + "'";
				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				data = jdbcTemplate.queryForList(sql);
				int default_rows = 4;
				int INFORO = default_rows;
				int SCDLRO = default_rows;
				int TASKRO = default_rows;
				if (!data.isEmpty()) {
					INFORO = ((Integer)(data.get(0).get("INFORO"))).intValue();
					SCDLRO = ((Integer)(data.get(0).get("SCDLRO"))).intValue();
					TASKRO = ((Integer)(data.get(0).get("TASKRO"))).intValue();
				}
				
				mav.setViewName("setting/show");
				mav.addObject("user_nu", user_nu);
				mav.addObject("INFORO", INFORO);
				mav.addObject("SCDLRO", SCDLRO);
				mav.addObject("TASKRO", TASKRO);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
    
    @RequestMapping(value = "/edit/inform_rows", method = RequestMethod.POST)
	public ModelAndView editInformRows(
			@RequestParam int user_nu,
			@RequestParam int info_rows) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			int session_user = ((Integer)(session.getAttribute("user_nu"))).intValue();
			if (session_user == user_nu) {
				
				try {
					int user = user_nu;
					String sql = "SELECT * FROM STNG WHERE USERNU='" + user + "'";
					List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
					data = jdbcTemplate.queryForList(sql);
					
					if (data.isEmpty()) {
						jdbcTemplate.update(
							"INSERT INTO STNG(USERNU,INFORO,SCDLRO,TASKRO) VALUE(?, ?, ?, ?)",
							user, info_rows, 4, 4
						);
					} else {
						jdbcTemplate.update(
							"UPDATE STNG SET INFORO=?,UDDTTM=current_timestamp WHERE USERNU=?",
							info_rows, user
						);
					}
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/setting");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
    
    @RequestMapping(value = "/edit/schedule_rows", method = RequestMethod.POST)
	public ModelAndView editScheduleRows(
			@RequestParam int user_nu,
			@RequestParam int scdl_rows) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			int session_user = ((Integer)(session.getAttribute("user_nu"))).intValue();
			if (session_user == user_nu) {
				
				try {
					int user = user_nu;
					String sql = "SELECT * FROM STNG WHERE USERNU='" + user + "'";
					List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
					data = jdbcTemplate.queryForList(sql);
					
					if (data.isEmpty()) {
						jdbcTemplate.update(
							"INSERT INTO STNG(USERNU,INFORO,SCDLRO,TASKRO) VALUE(?, ?, ?, ?)",
							user, 4, scdl_rows, 4
						);
					} else {
						jdbcTemplate.update(
							"UPDATE STNG SET SCDLRO=?,UDDTTM=current_timestamp WHERE USERNU=?",
							scdl_rows, user
						);
					}
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/setting");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
    
    @RequestMapping(value = "/edit/task_rows", method = RequestMethod.POST)
	public ModelAndView editTaskRows(
			@RequestParam int user_nu,
			@RequestParam int task_rows) {
    	if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			int session_user = ((Integer)(session.getAttribute("user_nu"))).intValue();
			if (session_user == user_nu) {
				
				try {
					int user = user_nu;
					String sql = "SELECT * FROM STNG WHERE USERNU='" + user + "'";
					List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
					data = jdbcTemplate.queryForList(sql);
					
					if (data.isEmpty()) {
						jdbcTemplate.update(
							"INSERT INTO STNG(USERNU,INFORO,SCDLRO,TASKRO) VALUE(?, ?, ?, ?)",
							user, 4, 4, task_rows
						);
					} else {
						jdbcTemplate.update(
							"UPDATE STNG SET TASKRO=?,UDDTTM=current_timestamp WHERE USERNU=?",
							task_rows, user
						);
					}
		        } catch (EmptyResultDataAccessException e) {
		        	e.printStackTrace();
		        }
				
				ModelAndView mav = new ModelAndView("redirect:/setting");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/top");
				return mav;
			}
		}
	}
}
