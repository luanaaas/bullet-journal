package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Factory class for creating instances of EventListCell as cells for a ListView
 */
public class EventListCellFactory implements Callback<ListView<Event>, ListCell<Event>> {

  /**
   * Creates a new instance of EventListCell as a cell for the ListView
   *
   * @param listView the ListView for which the cell is being created
   * @return the created ListCell instance
   */
  @Override
  public ListCell<Event> call(ListView<Event> listView) {
    return new EventListCell();
  }
}
