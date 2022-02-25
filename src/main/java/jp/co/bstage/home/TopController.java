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
import org.springframework.web.servlet.ModelAndView;

import jp.co.bstage.bean.Task;

@Controller
public class TopController extends SpringBootServletInitializer {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public static void main(String[] args) {
        SpringApplication.run(TopController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TopController.class);
    }
    
    @RequestMapping("/top")
	public ModelAndView top(ModelAndView mav) {
		if (session.getAttribute("user_id") == null || session.getAttribute("password") == null) {
			ModelAndView mav2 = new ModelAndView("redirect:/login");
			return mav2;
		} else {
			
			try {
				String user = (String) session.getAttribute("user_id");
				List<Map<String, Object>> infos = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> scdls = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
				
				String sql1 = "SELECT * FROM INFO ORDER BY INFOID ASC";
				infos = jdbcTemplate.queryForList(sql1);
				String sql2 = "SELECT * FROM SCDL ORDER BY SCDLID ASC";
				scdls = jdbcTemplate.queryForList(sql2);
				Task task = new Task();
				tasks = task.getTasks();
				
				mav.setViewName("home/top");
				mav.addObject("user", user);
				mav.addObject("infos", infos);
				mav.addObject("scdls", scdls);
				mav.addObject("tasks", tasks);
	        } catch (EmptyResultDataAccessException e) {
	        	e.printStackTrace();
	        }
			
			return mav;
		}
	}
}
