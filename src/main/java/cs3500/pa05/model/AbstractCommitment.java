package cs3500.pa05.model;

/**
 * An abstract class representing a commitment.
 */
public abstract class AbstractCommitment implements CommitmentInterface {

  /**
   * The name of the commitment
   */
  protected String name;

  /**
   * The description of the commitment
   */
  protected String description;

  /**
   * The day of the commitment
   */
  protected String day;

  /**
   * The category of the commitment
   */
  protected String category;

  /**
   * Constructs an AbstractCommitment object with the given parameters.
   *
   * @param name        the name of the commitment
   * @param description the description of the commitment
   * @param day         the day of the commitment
   * @param category    the category of the commitment
   */
  AbstractCommitment(String name, String description, String day, String category) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.category = category;
  }

  /**
   * Returns the category of the commitment.
   *
   * @return the category of the commitment
   */
  public String getCategory() {
    return category;
  }

  /**
   * Returns the description of the commitment.
   *
   * @return the description of the commitment
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the name of the commitment.
   *
   * @return the name of the commitment
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the day of the commitment.
   *
   * @return the day of the commitment
   */
  public String getDay() {
    return day;
  }
}
