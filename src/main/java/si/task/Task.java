package si.task;

import javax.persistence.*;

/**
 * Created by Alessandro Fook on 20/02/2017.
 */

@Entity
public class Task  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String titleName;

	@Column
	private boolean isDone;

	@Column
	private String priority;

	public Task() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTaskName(String titleName) {
		this.titleName = titleName;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean done) {
		isDone = done;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Task task = (Task) o;

		if (!getId().equals(task.getId())) return false;
		return getTitleName().equals(task.getTitleName());

	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getTitleName().hashCode();
		return result;
	}
}
