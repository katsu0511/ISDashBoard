package jp.co.bstage.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task {
	public ArrayList<Map<String, Object>> getTasks() {
		ArrayList<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
		Map<String, Object> task = new HashMap<>();
		task.put("TASKID", 1);
		task.put("PRJTNM", "案件A");
		task.put("TASKNM", "項目1");
		task.put("EXPRDT", "2022年1月30日");
		task.put("CHRGPS", "bsdev");
		task.put("PRCOST", 20);
		task.put("TASKCT", "タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。");
		tasks.add(task);
		task = new HashMap<>();
		task.put("TASKID", 2);
		task.put("PRJTNM", "案件B");
		task.put("TASKNM", "項目1");
		task.put("EXPRDT", "2022年1月30日");
		task.put("CHRGPS", "bsdev");
		task.put("PRCOST", 20);
		task.put("TASKCT", "タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。");
		tasks.add(task);
		task = new HashMap<>();
		task.put("TASKID", 3);
		task.put("PRJTNM", "案件B");
		task.put("TASKNM", "項目2");
		task.put("EXPRDT", "2022年1月30日");
		task.put("CHRGPS", "bsdev");
		task.put("PRCOST", 20);
		task.put("TASKCT", "タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。");
		tasks.add(task);
		task = new HashMap<>();
		task.put("TASKID", 4);
		task.put("PRJTNM", "案件B");
		task.put("TASKNM", "項目3");
		task.put("EXPRDT", "2022年1月30日");
		task.put("CHRGPS", "bsdev");
		task.put("PRCOST", 20);
		task.put("TASKCT", "タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。");
		tasks.add(task);
		task = new HashMap<>();
		task.put("TASKID", 5);
		task.put("PRJTNM", "案件B");
		task.put("TASKNM", "項目4");
		task.put("EXPRDT", "2022年1月30日");
		task.put("CHRGPS", "bsdev");
		task.put("PRCOST", 20);
		task.put("TASKCT", "タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。タスクの内容です。");
		tasks.add(task);
		
		return tasks;
	}
}
