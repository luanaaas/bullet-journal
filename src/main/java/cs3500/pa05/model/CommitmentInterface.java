package cs3500.pa05.model;

/**
 * Represents the interface for a commitment.
 */
public interface CommitmentInterface {

  /**
   * Returns the category of the commitment.
   *
   * @return the category
   */
  public String getCategory();

  /**
   * Returns the description of the commitment.
   *
   * @return the description
   */
  public String getDescription();

  /**
   * Returns the name of the commitment.
   *
   * @return the name
   */
  public String getName();

  /**
   * Returns the day of the commitment.
   *
   * @return the day
   */
  public String getDay();
}
