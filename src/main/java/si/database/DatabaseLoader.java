package si.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import si.task.Task;

/**
 * Created by Alessandro Fook on 23/02/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

	private final TaskBd dataBase;

	@Autowired
	public DatabaseLoader(TaskBd dataBase) {
		this.dataBase = dataBase;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		Task wakeUp = new Task();
		wakeUp.setTaskName("WakeUp");
		wakeUp.setPriority("warning");
		dataBase.save(wakeUp);

		Task sleep = new Task();
		sleep.setTaskName("Sleep");
		sleep.setPriority("success");
		dataBase.save(sleep);

	}
}
