package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TranslateFileTest {
  private File file;
  private ObjectMapper objectMapper;
  private TranslateFile translator;
  private Journal journal;

  @BeforeEach
  public void setup() {
    file = new File("src/main/resources/test.bujo");
    objectMapper = new ObjectMapper();
    journal = new Journal();
    translator = new TranslateFile(file, objectMapper);
    translator.readJsonFromFile();
    journal = new Journal(file);
  }

  @Test
  public void testReadFromJsonFile() {
    translator.readJsonFromFile();
    assertEquals(7, journal.getWeek().size());
    assertEquals(10, journal.getMaxEvents());
    assertEquals(4, journal.getMaxTasks());
  }


}