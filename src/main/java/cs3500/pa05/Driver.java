package cs3500.pa05;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.JournalControllerImp;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.JournalViewImp;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents the main driver of the journal
 */
public class Driver extends Application {

  /**
   * Starts the viewing of the scene
   *
   * @param stage where the scenes will be placed
   */
  @Override
  public void start(Stage stage) {

    stage.setTitle("Your Journal");

    JournalController controller = new JournalControllerImp(stage);
    JournalView view = new JournalViewImp(controller);

    try {
      stage.setScene(view.load());
      controller.run();
      stage.show();
    } catch (IllegalStateException | IOException e) {
      System.out.println(e.getMessage() + "Unable to load GUI");
    }

  }

  /**
   * Launches the journal project
   *
   * @param args given arguments to the main
   */
  public static void main(String[] args) {
    launch(args);
  }
}
