package cs3500.pa05.controller;

import cs3500.pa05.model.Task;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Custom ListCell implementation for rendering Task objects in a ListView.
 */
public class TaskListCell extends ListCell<Task> {
  @FXML
  private Label taskName;
  @FXML
  private TextFlow taskDesc;
  @FXML
  private Label completed;
  @FXML
  private Label category;
  @FXML
  private AnchorPane container;

  /**
   * Constructs a TaskListCell and loads the associated FXML layout.
   */
  public TaskListCell() {
    loadFxml();
  }

  /**
   * Loads the FXML layout for the TaskListCell.
   */
  private void loadFxml() {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/taskListCell.fxml"));
      fxmlLoader.setController(this);
      container = fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates the TaskListCell with the specified Task object.
   *
   * @param task  the Task to be displayed in the cell
   * @param empty true if the cell is empty, false otherwise
   */
  @Override
  protected void updateItem(Task task, boolean empty) {
    super.updateItem(task, empty);

    if (empty || task == null) {
      setGraphic(null);
    } else {
      taskName.setText(task.getName());
      taskDesc.getChildren().clear();

      String[] words = task.getDescription().split("\\s+");

      for (String word : words) {
        if (word.matches("^(http|https)://.*$")) {
          Hyperlink hyperlink = new Hyperlink(word);
          hyperlink.setOnAction(e -> {
            openUrl(word);
          });
          taskDesc.getChildren().add(hyperlink);
        } else {
          taskDesc.getChildren().add(new Text(word + " "));
        }
      }

      if (task.getComplete()) {
        completed.setText("Completed");
      } else {
        completed.setText("Not Completed");
      }
      category.setText(task.getCategory());
      setGraphic(container);
    }
  }

  /**
   * Opens the specified URL in the default browser.
   *
   * @param url the URL to be opened
   */
  private static void openUrl(String url) {
    try {
      URI uri = new URI(url);
      Desktop desktop = Desktop.getDesktop();
      if (desktop.isSupported(Desktop.Action.BROWSE)) {
        desktop.browse(uri);
      } else {
        System.out.println("Desktop browsing is not supported on this platform");
      }
    } catch (URISyntaxException | IOException e) {
      System.out.println("Failed to open URL: " + e.getMessage());
    }
  }
}
