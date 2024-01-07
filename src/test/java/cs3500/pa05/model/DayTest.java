package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTest {

  private Day day;

  @BeforeEach
  public void setUp() {
    day = new Day();
  }

  @Test
  public void testAddEventToDay() {
    Event event = new Event("Meeting", "", "MONDAY", "work",
        "10:00", 60);
    day.addEventToDay(event);

    List<Event> expectedEvents = new ArrayList<>();
    expectedEvents.add(event);

    assertEquals(1, day.getEvents().size());
    assertEquals(expectedEvents, day.getEvents());
  }

  @Test
  public void testAddTaskToDay() {
    Task task = new Task("Homework1", "PA01", "MONDAY", "", false);
    day.addTaskToDay(task);

    List<Task> expectedTasks = new ArrayList<>();
    expectedTasks.add(task);

    assertEquals(1, day.getTasks().size());
    assertEquals(expectedTasks, day.getTasks());
  }

  @Test
  void getEvents() {
    Event event = new Event("Meeting", "", "MONDAY", "work",
        "10:00", 60);
    Event event2 = new Event("Another Meeting", "for money", "MONDAY",
        "work",
        "10:00", 60);

    List<Event> expectedEvents = new ArrayList<>();
    expectedEvents.add(event);
    expectedEvents.add(event2);

    day.addEventToDay(event);
    day.addEventToDay(event2);

    assertEquals(2, day.getEvents().size());
    assertEquals(expectedEvents, day.getEvents());
  }

  @Test
  void getTasks() {
    Task task1 = new Task("Homework1", "PA01", "MONDAY", "", false);
    Task task2 = new Task("Homework2", "PA04", "TUESDAY", "", true);

    List<Task> expectedTasks = new ArrayList<>();
    expectedTasks.add(task1);
    expectedTasks.add(task2);

    day.addTaskToDay(task1);
    day.addTaskToDay(task2);

    assertEquals(2, day.getTasks().size());
    assertEquals(expectedTasks, day.getTasks());

  }
}