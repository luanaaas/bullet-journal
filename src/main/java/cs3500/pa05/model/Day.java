package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a day containing tasks and events.
 */
public class Day {
  private List<Task> tasks;
  private List<Event> events;

  /**
   * Constructs a new Day object with empty lists of tasks and events.
   */
  public Day() {
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
  }

  /**
   * Constructs a new Day object with the given lists of tasks and events.
   *
   * @param tasks  the list of tasks
   * @param events the list of events
   */
  public Day(List<Task> tasks, List<Event> events) {
    this.tasks = tasks;
    this.events = events;
  }

  /**
   * Adds an event to the day.
   *
   * @param event the event to be added
   */
  public void addEventToDay(Event event) {
    events.add(event);
  }

  /**
   * Adds a task to the day.
   *
   * @param task the task to be added
   */
  public void addTaskToDay(Task task) {
    tasks.add(task);
  }

  /**
   * Returns the list of events in the day.
   *
   * @return the list of events
   */
  public List<Event> getEvents() {
    return events;
  }

  /**
   * Returns the list of tasks in the day.
   *
   * @return the list of tasks
   */
  public List<Task> getTasks() {
    return tasks;
  }
}
