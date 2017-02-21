package si.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import si.task.Task;
import si.task.TaskBd;

import java.util.List;

/**
 * Created by Alessandro Fook on 20/02/2017.
 */

@Controller
public class taskController {

	@Autowired
	private TaskBd dataBase;

	public taskController() {}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndex() {
		ModelAndView model = new ModelAndView();

		model.setViewName("index");

		return model;
	}

	/**
	 * Salva uma task no banco de dados
	 * @param task - objeto a ser salvo
	 * @return uma cópia do objeto que deve ser usado no sistema
	 */
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public @ResponseBody
	Task saveTask(@RequestBody Task task){
		return dataBase.save(task);
	}

	/**
	 * Remove uma task do banco de dados e retorna para o requisitante
	 * @param taskToRemove - task a ser removida
	 * @return uma cópia da task removida acaso exista
	 */
	@RequestMapping(value = "/task/{titleName}", method = RequestMethod.DELETE)
	public @ResponseBody
	Task deleteTask(@PathVariable String titleName){
		Task task = dataBase.findByTitleName(titleName);
		dataBase.delete(task);
		return task;
	}

	@RequestMapping(value = "/task", method = RequestMethod.TRACE)
	public @ResponseBody
	List<Task> getAllTask(){
		return dataBase.findAll();
	}

}
