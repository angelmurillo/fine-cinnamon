package org.jobs.mtt.web;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.jobs.mtt.domain.Task;
import org.jobs.mtt.domain.User;
import org.jobs.mtt.service.TaskService;
import org.jobs.mtt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TaskService taskServiceImp;

	@Autowired
	UserService userServiceImp;

	@RequestMapping("/")
	public ModelAndView showWelcome(ModelMap model, Principal principal) {
		
		// TODO Delete it. Set users only for demo purpose
		if (userServiceImp.countUsers() == 0) {
			User user = new User("test");
			userServiceImp.addUser(user);
			User user2 = new User("test2");
			userServiceImp.addUser(user2);
		}
		
		String userName = principal.getName(); // get logged in username

		List<Task> findAllByUserTasks = taskServiceImp.findAllTasksByUser(userName);
		model.addAttribute("tasks", findAllByUserTasks);
		return new ModelAndView("index");
	}

	// #### Access mappings ######
	
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		logger.info("showLogin");
		return new ModelAndView("login");
	}

	@RequestMapping("/login_ok")
	public ModelAndView showLoginOk() {
		return new ModelAndView("login_ok");
	}

	@RequestMapping("/login_error")
	public ModelAndView showLoginFail() {
		return new ModelAndView("login_error");
	}

	@RequestMapping("/login_out")
	public ModelAndView showLoginOut() {
		return new ModelAndView("login_out");
	}

	
	// #### Bussiness mappings ######
	
	@RequestMapping("/add")
	public ModelAndView addTaskForm() {
		return new ModelAndView("add_task");
	}

	@RequestMapping(value = "/add/new", method = RequestMethod.POST)
	public ModelAndView addNewTask(@RequestParam("name") String name, @RequestParam("description") String desc, Principal principal) {
		Task task = new Task(name, desc, new Date(), false, userServiceImp.findUserByName(principal.getName()));
		taskServiceImp.addTask(task);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public ModelAndView deleteTaskForm(@PathVariable Long id) {
		taskServiceImp.deleteTask(taskServiceImp.findTask(id));
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateTask(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("checked") Boolean isDone) {
		Task task = taskServiceImp.findTask(id);
		task.setIsDone(isDone);
		taskServiceImp.updateTask(task);
		return new ModelAndView("redirect:/");
	}

}
