package cs3500.pa05.model;

/**
 * Represents a task in the journal.
 */
public class Task extends AbstractCommitment {
  private boolean completed;

  /**
   * Constructs a new Task.
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @param day         the day of the task
   * @param category    the category of the task
   * @param completed   the completion status of the task
   */
  public Task(String name, String description, String day, String category, boolean completed) {
    super(name, description, day, category);
    this.completed = completed;
  }

  /**
   * Returns the completion status of the task.
   *
   * @return true if the task is completed, false otherwise
   */
  public boolean getComplete() {
    return completed;
  }
}
