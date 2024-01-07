package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
  private Task task1;
  private Task task2;

  @BeforeEach
  void setUp() {
    task1 = new Task("Fill out form", "", "MONDAY",
        "work", true);
    task2 = new Task("Do homework", "hw1 ", "FRIDAY",
        "school", false);
  }

  @Test
  void testGetComplete() {
    assertTrue(task1.getComplete());
    assertFalse(task2.getComplete());
  }

}