package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
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
 * Custom ListCell for displaying events in a ListView.
 */
public class EventListCell extends ListCell<Event> {
  @FXML
  private Label eventName;
  @FXML
  private TextFlow eventDesc;
  @FXML
  private Label time;
  @FXML
  private Label duration;
  @FXML
  private Label category;
  @FXML
  private AnchorPane container;

  /**
   * Constructs an EventListCell.
   */
  public EventListCell() {
    loadFxml();
  }

  /**
   * Loads the FXML file and initializes the controller.
   */
  private void loadFxml() {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/eventListCell.fxml"));
      fxmlLoader.setController(this);
      container = fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void updateItem(Event event, boolean empty) {
    super.updateItem(event, empty);

    if (empty || event == null) {
      setGraphic(null);
    } else {
      eventName.setText(event.getName());
      eventDesc.getChildren().clear();

      String[] words = event.getDescription().split("\\s+");

      for (String word : words) {
        if (word.matches("^(http|https)://.*$")) {
          Hyperlink hyperlink = new Hyperlink(word);
          hyperlink.setOnAction(e -> {
            openUrl(word);
          });
          eventDesc.getChildren().add(hyperlink);
        } else {
          eventDesc.getChildren().add(new Text(word + " "));
        }
      }

      time.setText(event.getStartTime());
      duration.setText(String.valueOf(event.getDuration()));
      category.setText(event.getCategory());

      setGraphic(container);
    }
  }

  /**
   * Opens the provided URL in the default browser.
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
