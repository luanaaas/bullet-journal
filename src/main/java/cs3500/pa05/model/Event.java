package cs3500.pa05.model;

/**
 * Represents an event, which is a specific type of commitment.
 * An event has a start time and a duration.
 */
public class Event extends AbstractCommitment {
  private String startTime;
  private int duration;

  /**
   * Constructs an event with the specified name, description, day,
   * category, start time, and duration.
   *
   * @param name        the name of the event
   * @param description the description of the event
   * @param day         the day of the event
   * @param category    the category of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   */
  public Event(String name, String description, String day, String category,
               String startTime, int duration) {
    super(name, description, day, category);
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Returns the start time of the event.
   *
   * @return the start time of the event
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Returns the duration of the event.
   *
   * @return the duration of the event
   */
  public int getDuration() {
    return duration;
  }
}
