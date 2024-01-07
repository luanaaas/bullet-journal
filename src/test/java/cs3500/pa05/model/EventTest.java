package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

  private Event event;

  @BeforeEach
  void setUp() {
    String startTime = "10:00";
    int duration = 60;
    event = new Event("Meeting", "for getting the investor to invest",
        "FRIDAY", "work", startTime, duration);
  }

  @Test
  void testGetStartTime() {
    String startTime = "10:00";
    assertEquals(startTime, event.getStartTime());
  }

  @Test
  void testGetDuration() {
    assertEquals(60, event.getDuration());
  }

}