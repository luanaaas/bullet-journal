package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to translate journal data from a JSON file.
 */
public class TranslateFile {

  private File file;
  private final ObjectMapper objectMapper;
  private JournalJson journalJson;
  private List<DayJson> days;
  private ButtonInfoJson buttons;
  private OverviewJson overview;
  private QuotesAndNotesJson quotesNotes;

  /**
   * Constructs a new TranslateFile object.
   *
   * @param file          the JSON file to translate
   * @param objectMapper the ObjectMapper instance used for JSON processing
   */
  public TranslateFile(File file, ObjectMapper objectMapper) {
    this.file = file;
    this.objectMapper = objectMapper;
  }

  /**
   * Reads overall journal data from the file.
   */
  private void readJournalData() {
    try {
      JsonNode jsonNode = objectMapper.readTree(file);
      journalJson = objectMapper.readValue(jsonNode.toString(), JournalJson.class);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Reads the data from the JSON file.
   */
  public void readJsonFromFile() {
    readJournalData();
    days = journalJson.allDays(); // populates days with their tasks and events
    overview = journalJson.overview(); // populates the total tasks and events
    buttons = journalJson.buttonInfo(); // populates the categories and max values
    quotesNotes = journalJson.quotesNotes(); // populates the quotes and notes
  }

  /**
   * Translates a DayJson object to a Day object.
   *
   * @param i the index of the DayJson object to translate
   * @return the translated Day object
   */
  public Day translateDay(int i) {
    return new Day(readDayTasks(days.get(i)), readDayEvents(days.get(i)));
  }

  /**
   * Translates the categories from the JSON file.
   *
   * @return the list of translated categories
   */
  public List<String> translateCategories() {
    return buttons.categories();
  }

  /**
   * Translates the maximum number of tasks from the JSON file.
   *
   * @return the maximum number of tasks
   */
  public int translateMaxTasks() {
    return buttons.maxTasks();
  }

  /**
   * Translates the maximum number of events from the JSON file.
   *
   * @return the maximum number of events
   */
  public int translateMaxEvents() {
    return buttons.maxEvents();
  }

  /**
   * Translates the quotes and notes from the JSON file.
   *
   * @return the translated quotes and notes
   */
  public String translateNotesQuotes() {
    return quotesNotes.quotesNotes();
  }

  /**
   * Reads the list of tasks from a DayJson object.
   *
   * @param day the DayJson object to read tasks from
   * @return the list of translated tasks
   */
  private List<Task> readDayTasks(DayJson day) {
    List<TaskJson> taskJsonList = day.tasks();
    List<Task> taskList = new ArrayList<>();
    for (TaskJson taskJson : taskJsonList) {
      Task task = new Task(
          taskJson.name(),
          taskJson.description(),
          taskJson.day(),
          taskJson.category(),
          taskJson.completed());
      taskList.add(task);
    }
    return taskList;
  }

  /**
   * Reads the list of events from a DayJson object.
   *
   * @param day the DayJson object to read events from
   * @return the list of translated events
   */
  private List<Event> readDayEvents(DayJson day) {
    List<EventJson> eventJsonList = day.events();
    List<Event> eventList = new ArrayList<>();
    for (EventJson eventJson : eventJsonList) {
      Event event = new Event(
          eventJson.name(),
          eventJson.description(),
          eventJson.day(),
          eventJson.category(),
          eventJson.startTime(),
          eventJson.duration());
      eventList.add(event);
    }
    return eventList;
  }
}
