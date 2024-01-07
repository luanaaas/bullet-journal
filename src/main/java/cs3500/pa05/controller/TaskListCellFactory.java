package cs3500.pa05.controller;

import cs3500.pa05.model.Task;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Factory class for creating TaskListCell instances to be used in a ListView.
 */
public class TaskListCellFactory implements Callback<ListView<Task>, ListCell<Task>> {

  /**
   * Creates a TaskListCell to be used in a ListView.
   *
   * @param listView the ListView in which the TaskListCell will be used
   * @return a new TaskListCell instance
   */
  @Override
  public ListCell<Task> call(ListView<Task> listView) {
    return new TaskListCell();
  }
}
