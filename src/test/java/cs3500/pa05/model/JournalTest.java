package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JournalTest {
  private Journal journal;
  private TranslateFile translator;
  private File file;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    file = new File("src/main/resources/test.bujo");
    objectMapper = new ObjectMapper();
    journal = new Journal();
    translator = new TranslateFile(file, objectMapper);
    translator.readJsonFromFile();
    journal = new Journal(file);
  }

  @Test
  void testExceedsMaxTasks() {
    journal.setMaxTasks(5);
    assertFalse(journal.exceedsMaxTasks());
  }

  @Test
  void testExceedsMaxTasks2() {
    journal.setMaxTasks(2);
    journal.addTask(new Task("Finish Homework", "", "MONDAY", "school", false));
    assertTrue(journal.exceedsMaxTasks());
  }

  @Test
  void testExceedsMaxEvents() {
    journal.setMaxEvents(10);
    assertFalse(journal.exceedsMaxEvents());
  }

  @Test
  void testExceedsMaxEvents2() {
    journal.setMaxEvents(3);
    journal.addEvent(new Event("Birthday", "at the park", "TUESDAY", "friends",
        "10:00", 120));
    journal.addEvent(new Event("Party", "", "TUESDAY", "fun",
        "12:00", 60));
    journal.addEvent(new Event("Bonfire", "potluck", "TUESDAY", "fun",
        "15:00", 200));
    journal.addEvent(new Event("Wedding", "bring plus 1", "TUESDAY", "family",
        "18:00", 300));
    assertTrue(journal.exceedsMaxEvents());
  }

  @Test
  void testAddTaskMon() {
    Task task = new Task("Fill out form", "", "MONDAY",
        "work", true);
    journal.addTask(task);
    List<Task> mondayTasks = journal.getMonday().getTasks();
    assertTrue(mondayTasks.contains(task));
  }

  @Test
  void testAddTaskSun() {

    Task task1 = new Task("Fill out form", "", "SUNDAY",
        "work", true);
    journal.addTask(task1);
    List<Task> sunTasks = journal.getSunday().getTasks();
    assertTrue(sunTasks.contains(task1));
  }

  @Test
  void testAddTaskTue() {
    Task task2 = new Task("Fill out form", "", "TUESDAY",
        "work", true);
    journal.addTask(task2);
    List<Task> tueTasks = journal.getTuesday().getTasks();
    assertTrue(tueTasks.contains(task2));
  }

  @Test
  public void testAddTaskWed() {
    Task task3 = new Task("Fill out form", "", "WEDNESDAY",
        "work", true);
    journal.addTask(task3);
    List<Task> wedTasks = journal.getWednesday().getTasks();
    assertTrue(wedTasks.contains(task3));
  }

  @Test
  private void testAddTaskThu() {
    Task task3 = new Task("Fill out form", "", "THURSDAY",
        "work", true);
    journal.addTask(task3);
    List<Task> thuTasks = journal.getThursday().getTasks();
    assertTrue(thuTasks.contains(task3));
  }

  @Test
  private void testAddTaskFri() {
    Task task = new Task("Fill out form", "", "FRIDAY",
        "work", true);
    journal.addTask(task);
    List<Task> tasks = journal.getFriday().getTasks();
    assertTrue(tasks.contains(task));
  }

  @Test
  private void testAddTaskSat() {
    Task task = new Task("Fill out form", "", "SATURDAY",
        "work", true);
    journal.addTask(task);
    List<Task> tasks = journal.getSaturday().getTasks();
    assertTrue(tasks.contains(task));
  }

  @Test
  void testAddEvent() {
    Event event = new Event("Meeting", "for getting the investor to invest",
        "FRIDAY", "work", "10:00", 50);
    journal.addEvent(event);
    List<Event> fridayEvents = journal.getFriday().getEvents();
    assertTrue(fridayEvents.contains(event));

    Event event1 = new Event("Meeting", "for getting the investor to invest",
        "SUNDAY", "work", "10:00", 50);
    journal.addEvent(event1);
    List<Event> sundayEvents = journal.getSunday().getEvents();
    assertTrue(sundayEvents.contains(event1));

    Event event2 = new Event("Meeting", "for getting the investor to invest",
        "MONDAY", "work", "10:00", 50);
    journal.addEvent(event2);
    List<Event> monEvents = journal.getMonday().getEvents();
    assertTrue(monEvents.contains(event2));

    Event event3 = new Event("Meeting", "for getting the investor to invest",
        "WEDNESDAY", "work", "10:00", 50);
    journal.addEvent(event3);
    List<Event> wedEvents = journal.getWednesday().getEvents();
    assertTrue(wedEvents.contains(event3));

    Event event4 = new Event("Meeting", "for getting the investor to invest",
        "THURSDAY", "work", "10:00", 50);
    journal.addEvent(event4);
    List<Event> thuEvents = journal.getThursday().getEvents();
    assertTrue(thuEvents.contains(event4));

    Event event5 = new Event("Meeting", "for getting the investor to invest",
        "SATURDAY", "work", "10:00", 50);
    journal.addEvent(event5);
    List<Event> satEvents = journal.getSaturday().getEvents();
    assertTrue(satEvents.contains(event5));
  }

  @Test
  void testAddCategory() {
    String category = "work";
    journal.addCategory(category);
    Event event5 = new Event("Meeting", "for getting the investor to invest",
        "SATURDAY", "work", "10:00", 50);
    assertEquals("work", event5.getCategory());
  }

  @Test
  void testSetMaxTasks() {
    int maxTasks = 10;
    journal.setMaxTasks(maxTasks);
    assertEquals(maxTasks, journal.getMaxTasks());
    assertEquals(10, journal.getMaxTasks());
  }

  @Test
  void testSetMaxEvents() {
    int maxEvents = 5;
    journal.setMaxEvents(maxEvents);
    assertEquals(maxEvents, journal.getMaxEvents());
    assertEquals(5, journal.getMaxEvents());
  }

  @Test
  void testSaveFile() {
    journal.saveFile();
    File savedFile = journal.getFile();
    assertNotNull(savedFile);
    assertTrue(savedFile.exists());
  }

  @Test
  void testGetFile() {
    File journalFile = journal.getFile();
    assertEquals(file, journalFile);
  }

  @Test
  void testGetDays() {
    Day saturday = journal.getSaturday();
    assertEquals(0, saturday.getEvents().size());
  }

  @Test
  void testGetWeek() {
    List<Day> week = journal.getWeek();
    assertEquals(7, week.size());
  }

  @Test
  void testGetNotesQuotes() {
    String expectedNotes = "This is a sample quotes n notes.";
    assertEquals(expectedNotes, journal.getNotesQuotes());
  }

  @Test
  void testGetAllEvents() {
    assertEquals(2, journal.getAllEvents().size());
  }

  @Test
  void testGetAllTasks() {
    assertEquals(4, journal.getAllTasks().size());
  }


  @Test
  void setFile() {
    journal.setFile(file);
    assertEquals(file, journal.getFile());
  }
}