package si.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.task.Task;

/**
 * Created by Alessandro Fook on 20/02/2017.
 */
@Repository
public interface TaskBd extends JpaRepository<Task, Integer> {
	Task findByTitleName(String titleName);
}
