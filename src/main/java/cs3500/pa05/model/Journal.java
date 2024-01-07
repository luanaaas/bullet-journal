package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a journal that stores tasks, events, and other related information.
 */
public class Journal {

  private Day sunday;
  private Day monday;
  private Day tuesday;
  private Day wednesday;
  private Day thursday;
  private Day friday;
  private Day saturday;
  private List<Day> week = new ArrayList<>();
  private List<String> categories;
  private List<Event> allEvents;
  private List<Task> allTasks;
  private int maxTasks;
  private int maxEvents;
  private String notesQuotes;
  private File file;

  /**
   * Constructs a new Journal object with default values.
   */
  public Journal() {
    sunday = new Day();
    monday = new Day();
    tuesday = new Day();
    wednesday = new Day();
    thursday = new Day();
    friday = new Day();
    saturday = new Day();
    week.addAll(List.of(sunday, monday, tuesday, wednesday, thursday, friday, saturday));
    categories = new ArrayList<>(List.of("No Category"));
    allTasks = new ArrayList<>();
    allEvents = new ArrayList<>();
    maxTasks = 0;
    maxEvents = 0;
    notesQuotes = "";
  }

  /**
   * Constructs a new Journal object with data loaded from a file.
   *
   * @param bujo the file containing the journal data
   */
  public Journal(File bujo) {
    file = bujo;
    TranslateFile translator = new TranslateFile(file, new ObjectMapper());
    translator.readJsonFromFile();
    sunday = translator.translateDay(0);
    monday = translator.translateDay(1);
    tuesday = translator.translateDay(2);
    wednesday = translator.translateDay(3);
    thursday = translator.translateDay(4);
    friday = translator.translateDay(5);
    saturday = translator.translateDay(6);
    week.addAll(List.of(sunday, monday, tuesday, wednesday, thursday, friday, saturday));
    categories = translator.translateCategories();
    maxTasks = translator.translateMaxTasks();
    maxEvents = translator.translateMaxEvents();
    notesQuotes = translator.translateNotesQuotes();
    initAllLists();
  }

  private void initAllLists() {
    allTasks = new ArrayList<>();
    allEvents = new ArrayList<>();
    for (Day day : week) {
      allTasks.addAll(day.getTasks());
      allEvents.addAll(day.getEvents());
    }
  }

  /**
   * Checks if any day in the journal exceeds the maximum number of tasks allowed.
   *
   * @return true if the maximum number of tasks is exceeded, false otherwise
   */
  public boolean exceedsMaxTasks() {
    for (Day day : week) {
      if (day.getTasks().size() >= maxTasks) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if any day in the journal exceeds the maximum number of events allowed.
   *
   * @return true if the maximum number of events is exceeded, false otherwise
   */
  public boolean exceedsMaxEvents() {
    for (Day day : week) {
      if (day.getEvents().size() > maxEvents) {
        return true;
      }
    }
    return false;
  }

  /**
   * Adds a task to the journal.
   *
   * @param newTask the task to add
   */
  public void addTask(Task newTask) {
    if (newTask.getDay().equals("SUNDAY")) {
      sunday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("MONDAY")) {
      monday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("TUESDAY")) {
      tuesday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("WEDNESDAY")) {
      wednesday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("THURSDAY")) {
      thursday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("FRIDAY")) {
      friday.addTaskToDay(newTask);
    } else if (newTask.getDay().equals("SATURDAY")) {
      saturday.addTaskToDay(newTask);
    }
    initAllLists();
  }

  /**
   * Adds an event to the journal.
   *
   * @param newEvent the event to add
   */
  public void addEvent(Event newEvent) {
    if (newEvent.getDay().equals("SUNDAY")) {
      sunday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("MONDAY")) {
      monday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("TUESDAY")) {
      tuesday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("WEDNESDAY")) {
      wednesday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("THURSDAY")) {
      thursday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("FRIDAY")) {
      friday.addEventToDay(newEvent);
    } else if (newEvent.getDay().equals("SATURDAY")) {
      saturday.addEventToDay(newEvent);
    }
    initAllLists();
  }

  /**
   * Adds a category to the journal.
   *
   * @param category the category to add
   */
  public void addCategory(String category) {
    categories.add(category);
  }

  /**
   * Sets the maximum number of tasks allowed.
   *
   * @param max the maximum number of tasks
   */
  public void setMaxTasks(int max) {
    maxTasks = max;
  }

  /**
   * Sets the maximum number of events allowed.
   *
   * @param max the maximum number of events
   */
  public void setMaxEvents(int max) {
    maxEvents = max;
  }

  /**
   * Returns the Day object representing Saturday in the journal.
   *
   * @return the Saturday Day object
   */
  public Day getSaturday() {
    return saturday;
  }

  /**
   * Returns the Day object representing Friday in the journal.
   *
   * @return the Friday Day object
   */
  public Day getFriday() {
    return friday;
  }

  /**
   * Returns a list of all the Day objects in the journal.
   *
   * @return a list of Day objects
   */
  public List<Day> getWeek() {
    return week;
  }

  /**
   * Returns the Day object representing Thursday in the journal.
   *
   * @return the Thursday Day object
   */
  public Day getThursday() {
    return thursday;
  }

  /**
   * Returns the Day object representing Wednesday in the journal.
   *
   * @return the Wednesday Day object
   */
  public Day getWednesday() {
    return wednesday;
  }

  /**
   * Returns the Day object representing Tuesday in the journal.
   *
   * @return the Tuesday Day object
   */
  public Day getTuesday() {
    return tuesday;
  }

  /**
   * Returns the Day object representing Monday in the journal.
   *
   * @return the Monday Day object
   */
  public Day getMonday() {
    return monday;
  }

  /**
   * Returns the Day object representing Sunday in the journal.
   *
   * @return the Sunday Day object
   */
  public Day getSunday() {
    return sunday;
  }

  /**
   * Returns the maximum number of tasks allowed.
   *
   * @return the maximum number of tasks
   */
  public int getMaxTasks() {
    return maxTasks;
  }

  /**
   * Returns the maximum number of events allowed.
   *
   * @return the maximum number of events
   */
  public int getMaxEvents() {
    return maxEvents;
  }

  /**
   * Returns a list of all the events in the journal.
   *
   * @return a list of Event objects
   */
  public List<Event> getAllEvents() {
    return allEvents;
  }

  /**
   * Returns a list of all the tasks in the journal.
   *
   * @return a list of Task objects
   */
  public List<Task> getAllTasks() {
    return allTasks;
  }

  /**
   * Returns the notes and quotes associated with the journal.
   *
   * @return the notes and quotes
   */
  public String getNotesQuotes() {
    return notesQuotes;
  }

  /**
   * Saves the journal data to a file.
   */
  public void saveFile() {
    JournalJson journalJson = createJournalJson();
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    try {
      mapper.writeValue(new File(file.getAbsolutePath()), journalJson);
    } catch (IOException e) {
      System.out.println("Failed to save journal to file: " + e.getMessage());
    }
  }

  private JournalJson createJournalJson() {
    List<DayJson> allDays = new ArrayList<>();
    for (Day day : week) {
      allDays.add(createDayJson(day));
    }
    OverviewJson overviewJson = new OverviewJson(allEvents.size(), allTasks.size());
    ButtonInfoJson buttonInfoJson = new ButtonInfoJson(categories, maxTasks, maxEvents);
    QuotesAndNotesJson quotesAndNotesJson = new QuotesAndNotesJson(notesQuotes);

    return new JournalJson(allDays, overviewJson, buttonInfoJson, quotesAndNotesJson);
  }

  private DayJson createDayJson(Day day) {
    List<TaskJson> taskJsonList = new ArrayList<>();
    for (Task task : day.getTasks()) {
      taskJsonList.add(createTaskJson(task));
    }

    List<EventJson> eventJsonList = new ArrayList<>();
    for (Event event : day.getEvents()) {
      eventJsonList.add(createEventJson(event));
    }

    return new DayJson(taskJsonList, eventJsonList);
  }

  private TaskJson createTaskJson(Task task) {
    return new TaskJson(
        task.getName(),
        task.getDescription(),
        task.getDay(),
        task.getCategory(),
        task.getComplete()
    );
  }

  private EventJson createEventJson(Event event) {
    return new EventJson(
        event.getName(),
        event.getDescription(),
        event.getDay(),
        event.getCategory(),
        event.getStartTime(),
        event.getDuration()
    );
  }

  /**
   * Returns the file associated with the journal.
   *
   * @return the journal file
   */
  public File getFile() {
    return file;
  }

  /**
   * Sets the file associated with the journal.
   *
   * @param file the journal file
   */
  public void setFile(File file) {
    this.file = file;
  }

  /**
   * Returns a list of all the categories in the journal.
   *
   * @return a list of categories
   */
  public List<String> getCategories() {
    return categories;
  }
}
