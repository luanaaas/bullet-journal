package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Journal;
import cs3500.pa05.model.Task;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Controller class for the journal application.
 */
public class JournalControllerImp implements JournalController {

  private ObservableList<Event> sunEvents = FXCollections.observableArrayList();
  private ObservableList<Event> monEvents = FXCollections.observableArrayList();
  private ObservableList<Event> tuesEvents = FXCollections.observableArrayList();
  private ObservableList<Event> wedEvents = FXCollections.observableArrayList();
  private ObservableList<Event> thurEvents = FXCollections.observableArrayList();
  private ObservableList<Event> friEvents = FXCollections.observableArrayList();
  private ObservableList<Event> satEvents = FXCollections.observableArrayList();
  private ObservableList<Task> sunTasks = FXCollections.observableArrayList();
  private ObservableList<Task> monTasks = FXCollections.observableArrayList();
  private ObservableList<Task> tuesTasks = FXCollections.observableArrayList();
  private ObservableList<Task> wedTasks = FXCollections.observableArrayList();
  private ObservableList<Task> thurTasks = FXCollections.observableArrayList();
  private ObservableList<Task> friTasks = FXCollections.observableArrayList();
  private ObservableList<Task> satTasks = FXCollections.observableArrayList();
  private ObservableList<Task> allTasks = FXCollections.observableArrayList();
  private ObservableList<Event> allEvents = FXCollections.observableArrayList();
  @FXML
  private Button blue;
  @FXML
  private Button red;
  @FXML
  private Button purple;
  @FXML
  private Button green;
  @FXML
  private AnchorPane background;
  @FXML
  private ListView<Event> sunEventsList;
  @FXML
  private ListView<Event> monEventsList;
  @FXML
  private ListView<Event> tuesEventsList;
  @FXML
  private ListView<Event> wedEventsList;
  @FXML
  private ListView<Event> thurEventsList;
  @FXML
  private ListView<Event> friEventsList;
  @FXML
  private ListView<Event> satEventsList;
  @FXML
  private ListView<Task> sunTasksList;
  @FXML
  private ListView<Task> monTasksList;
  @FXML
  private ListView<Task> tuesTasksList;
  @FXML
  private ListView<Task> wedTasksList;
  @FXML
  private ListView<Task> thurTasksList;
  @FXML
  private ListView<Task> friTasksList;
  @FXML
  private ListView<Task> satTasksList;
  @FXML
  private Button openFile;
  @FXML
  private Button openTemplate;
  @FXML
  private Button save;
  @FXML
  private Button category;
  @FXML
  private Button task;
  @FXML
  private Button event;
  @FXML
  private TextField eventName;
  @FXML
  private TextField eventDescription;
  @FXML
  private TextField eventStartTime;
  @FXML
  private TextField eventDuration;
  @FXML
  private TextField taskName;
  @FXML
  private TextField taskDescription;
  @FXML
  private TextField maxTasks;
  @FXML
  private TextField maxEvents;
  @FXML
  private SplitMenuButton daysEvent;
  @FXML
  private SplitMenuButton daysTask;
  @FXML
  private Button doneEvent;
  @FXML
  private Button doneTask;

  private EventListCellFactory eventListCellFactory;
  private TaskListCellFactory taskListCellFactory;

  @FXML
  private TextField notesAndQuotes;
  @FXML
  private Label totalEvents;
  @FXML
  private Label totalTasks;
  @FXML
  private Label taskPercent;
  @FXML
  private ListView<Task> taskbarList;
  @FXML
  private Stage stage;
  private Popup eventPopup;
  private Popup taskPopup;
  private Popup categoryPopup;
  private Popup warningPopup;
  @FXML
  private SplitMenuButton allCategoriesTask;
  @FXML
  private SplitMenuButton allCategoriesEvent;
  @FXML
  private SplitMenuButton completed;
  @FXML
  private TextField newCategory;
  @FXML
  private Button doneCategory;
  @FXML
  private Button xxCategory;
  @FXML
  private Button xxEvent;
  @FXML
  private Button xxTask;
  @FXML
  private ProgressBar sunProgress;
  @FXML
  private Label sunTasksRemaining;
  @FXML
  private ProgressBar monProgress;
  @FXML
  private Label monTasksRemaining;
  @FXML
  private ProgressBar tueProgress;
  @FXML
  private Label tueTasksRemaining;
  @FXML
  private ProgressBar wedProgress;
  @FXML
  private Label wedTasksRemaining;
  @FXML
  private ProgressBar thuProgress;
  @FXML
  private Label thuTasksRemaining;
  @FXML
  private ProgressBar friProgress;
  @FXML
  private Label friTasksRemaining;
  @FXML
  private ProgressBar satProgress;
  @FXML
  private Label satTasksRemaining;
  @FXML
  private Button closeWarning;
  private String[] eventItems = new String[2];
  private String[] taskItems = new String[3];
  private Journal journal;
  private Journal template;

  /**
   * Constructs a JournalControllerImp with the specified stage.
   *
   * @param stage the stage to be used for popups
   */
  public JournalControllerImp(Stage stage) {
    this.stage = stage; // for popup usage
    this.eventListCellFactory = new EventListCellFactory();
    this.taskListCellFactory = new TaskListCellFactory();
    journal = new Journal();
  }

  /**
   * Initializes and runs the journal application.
   */
  @FXML
  public void run() {
    initWeek();
    initPopups();
    initButtons();
    setupListViewCellFactories();
    initStatsBar();
    initMaxes();
    handleProgressBars();
    background.setStyle("-fx-background-color: #5eafff");
    updateAllContainers("-fx-background-color: #b8d6f5");
    setBackground();

  }

  /**
   * Initializes the week by calling the methods to initialize tasks and events.
   */
  @FXML
  private void initWeek() {
    initTasks();
    initEvents();
  }

  /**
   * Initializes the task lists for each day of the week and sets the items in the
   * corresponding list views.
   */
  @FXML
  private void initTasks() {
    sunTasksList.setItems(sunTasks);
    monTasksList.setItems(monTasks);
    tuesTasksList.setItems(tuesTasks);
    wedTasksList.setItems(wedTasks);
    thurTasksList.setItems(thurTasks);
    friTasksList.setItems(friTasks);
    satTasksList.setItems(satTasks);
  }

  /**
   * Initializes the task bar by adding all the tasks from each day of the week and setting
   * the items in the taskbar_list.
   */
  @FXML
  private void initTaskBar() {
    allTasks.clear();
    allTasks.addAll(sunTasks);
    allTasks.addAll(monTasks);
    allTasks.addAll(tuesTasks);
    allTasks.addAll(wedTasks);
    allTasks.addAll(thurTasks);
    allTasks.addAll(friTasks);
    allTasks.addAll(satTasks);
    taskbarList.setItems(allTasks);
  }

  /**
   * Initializes the event lists for each day of the week and sets the items in the
   * corresponding list views.
   */
  @FXML
  private void initEvents() {
    sunEventsList.setItems(sunEvents);
    monEventsList.setItems(monEvents);
    tuesEventsList.setItems(tuesEvents);
    wedEventsList.setItems(wedEvents);
    thurEventsList.setItems(thurEvents);
    friEventsList.setItems(friEvents);
    satEventsList.setItems(satEvents);
  }

  /**
   * Sets up the cell factories for the list views that display events and tasks for
   * each day of the week.
   */
  private void setupListViewCellFactories() {
    sunEventsList.setCellFactory(eventListCellFactory);
    monEventsList.setCellFactory(eventListCellFactory);
    tuesEventsList.setCellFactory(eventListCellFactory);
    wedEventsList.setCellFactory(eventListCellFactory);
    thurEventsList.setCellFactory(eventListCellFactory);
    friEventsList.setCellFactory(eventListCellFactory);
    satEventsList.setCellFactory(eventListCellFactory);

    sunTasksList.setCellFactory(taskListCellFactory);
    monTasksList.setCellFactory(taskListCellFactory);
    tuesTasksList.setCellFactory(taskListCellFactory);
    wedTasksList.setCellFactory(taskListCellFactory);
    thurTasksList.setCellFactory(taskListCellFactory);
    friTasksList.setCellFactory(taskListCellFactory);
    satTasksList.setCellFactory(taskListCellFactory);
    taskbarList.setCellFactory(taskListCellFactory);
  }


  /**
   * Initializes the popups used for events, tasks, and warnings.
   */
  private void initPopups() {
    eventPopup = new Popup();
    taskPopup = new Popup();
    warningPopup = new Popup();
  }

  /**
   * Initializes the buttons and their corresponding event handlers.
   */
  @FXML
  private void initButtons() {
    openFile.setOnAction(event -> openBujoFile());
    openTemplate.setOnAction(event -> openTemplate());
    event.setOnAction(event -> makeEventPopup());
    handleEventButton();
    task.setOnAction(e -> makeTaskPopup());
    handleTaskButton();
    category.setOnAction(e -> makeCategoryPopup());
    handleCategoryButton();
    save.setOnAction(event -> handleSave());
  }

  /**
   * Initializes the maximum values for tasks and events and adds listeners to update the max.
   */
  private void initMaxes() {
    maxTasks.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
                          String newValue) {
        try {
          int newMaxTasks = Integer.parseInt(newValue);
          journal.setMaxTasks(newMaxTasks);
          checkMaxes();
        } catch (NumberFormatException e) {
          System.out.println(e.getMessage());
        }
      }
    });

    maxEvents.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
                          String newValue) {
        try {
          int newMaxEvents = Integer.parseInt(newValue);
          journal.setMaxEvents(newMaxEvents);
          checkMaxes();
        } catch (NumberFormatException e) {
          System.out.println(e.getMessage());
        }
      }
    });
  }

  /**
   * Clears the journal by clearing the task and event lists.
   */
  private void clearJournal() {
    allTasks.clear();
    clearTasks();
    clearEvents();
  }

  /**
   * Opens a .bujo file using a file chooser dialog and loads its contents into the journal.
   */
  private void openBujoFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open .bujo File");
    fileChooser.getExtensionFilters()
        .add(new FileChooser.ExtensionFilter("Bujo Files", "*.bujo"));
    File selectedFile = fileChooser.showOpenDialog(stage);
    journal = new Journal(selectedFile);
    if (selectedFile != null) {
      clearJournal();
      loadBujoFile(selectedFile);
    }
  }


  /**
   * Opens a template .bujo file using a file chooser dialog and loads its contents to the template.
   */
  private void openTemplate() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open .bujo File");
    fileChooser.getExtensionFilters()
        .add(new FileChooser.ExtensionFilter("Bujo Files", "*.bujo"));
    File selectedFile = fileChooser.showOpenDialog(stage);
    template = new Journal(selectedFile);
    if (selectedFile != null) {
      loadTemplate();
    }
  }

  /**
   * Loads the template contents into the journal by setting the maximum tasks and event
   * based on the template,
   */
  private void loadTemplate() {
    journal.setMaxTasks(template.getMaxTasks());
    journal.setMaxEvents(template.getMaxEvents());
    initMaxEventsAndTasks();
    handleSave();
  }

  /**
   * Loads the contents of a .bujo file into the journal
   *
   * @param file The .bujo file to load.
   */
  private void loadBujoFile(File file) {
    journal = new Journal(file);
    loadTasks();
    loadEvents();
    initTaskBar();
    initStatsBar();
    initQuotesNotes();
    initMaxEventsAndTasks();
    handleProgressBars();
  }

  /**
   * Clears the task lists for each day of the week.
   */
  private void clearTasks() {
    sunTasks.clear();
    monTasks.clear();
    tuesTasks.clear();
    wedTasks.clear();
    thurTasks.clear();
    friTasks.clear();
    satTasks.clear();
  }

  /**
   * Clears the event lists for each day of the week.
   */
  private void clearEvents() {
    sunEvents.clear();
    monEvents.clear();
    tuesEvents.clear();
    wedEvents.clear();
    thurEvents.clear();
    friEvents.clear();
    satEvents.clear();
  }

  /**
   * Loads the tasks from the journal into the respective task lists for each day of the week.
   */
  private void loadTasks() {
    clearTasks();
    sunTasks.addAll(journal.getSunday().getTasks());
    monTasks.addAll(journal.getMonday().getTasks());
    tuesTasks.addAll(journal.getTuesday().getTasks());
    wedTasks.addAll(journal.getWednesday().getTasks());
    thurTasks.addAll(journal.getThursday().getTasks());
    friTasks.addAll(journal.getFriday().getTasks());
    satTasks.addAll(journal.getSaturday().getTasks());
  }

  /**
   * Loads the events from the journal into the respective event lists for each day of the week.
   */
  private void loadEvents() {
    clearEvents();
    sunEvents.addAll(journal.getSunday().getEvents());
    monEvents.addAll(journal.getMonday().getEvents());
    tuesEvents.addAll(journal.getTuesday().getEvents());
    wedEvents.addAll(journal.getWednesday().getEvents());
    thurEvents.addAll(journal.getThursday().getEvents());
    friEvents.addAll(journal.getFriday().getEvents());
    satEvents.addAll(journal.getSaturday().getEvents());
  }

  /**
   * Displays the event popup window.
   */
  @FXML
  private void makeEventPopup() {
    this.eventPopup.show(this.stage);
  }

  /**
   * Displays the task popup window.
   */
  @FXML
  public void makeTaskPopup() {
    this.taskPopup.show(this.stage);
  }

  /**
   * Handles the event button action by initializing and configuring the event popup window,
   * setting up event-related menu items and their actions, and adding the popup content.
   */
  @FXML
  private void handleEventButton() {
    try {
      this.eventPopup = new Popup();
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("eventPopup.fxml"));
      loader.setController(this);
      Scene s = loader.load();
      // Set up days_event menu items and actions
      daysEvent.setOnAction(e -> {
        for (MenuItem menuItem : daysEvent.getItems()) {
          menuItem.setOnAction(event -> {
            eventItems[0] = menuItem.getText();
            daysEvent.setText(eventItems[0]);
          });
        }
      });
      // Set up all_categories_event menu items and actions
      allCategoriesEvent.setOnAction(e -> {
        for (MenuItem menuItem : allCategoriesEvent.getItems()) {
          menuItem.setOnAction(event -> {
            eventItems[1] = menuItem.getText();
            allCategoriesEvent.setText(eventItems[1]);
          });
        }
      });
      // Set up x_event button action
      xxEvent.setOnAction(e -> {
        clearEventWhenDone();
        eventPopup.hide();
      });
      // Set up done_event button action
      doneEvent.setOnAction(e -> handleDoneEvent());
      eventPopup.getContent().add((Node) s.getRoot());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Handles the done_event button action by creating a new Event object using the inputs
   */
  private void handleDoneEvent() {
    Event newEvent = createEventFromPopupInput(eventItems[0], eventItems[1]);
    if (newEvent.getName() != null
        && newEvent.getDay() != null
        && newEvent.getCategory() != null
        && newEvent.getStartTime() != null) {
      journal.addEvent(newEvent);
      checkMaxes();
      loadEvents();
      clearEventWhenDone();
      eventPopup.hide();
    }
  }

  /**
   * Creates a new Event object using the input from the event popup.
   *
   * @param day      The selected day for the event.
   * @param category The selected category for the event.
   * @return A new Event object with the specified properties.
   */
  @FXML
  private Event createEventFromPopupInput(String day, String category) {
    String name = eventName.getText();
    String description = eventDescription.getText();
    String startTime = eventStartTime.getText();
    String durationText = eventDuration.getText();
    int duration = 0;
    try {
      duration = Integer.parseInt(durationText);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }

    return new Event(name, description, day, category, startTime, duration);
  }

  /**
   * Clears the input fields and selected values in the event popup when the event is done.
   */
  private void clearEventWhenDone() {
    eventName.clear();
    eventDescription.clear();
    eventStartTime.clear();
    eventDuration.clear();
    daysEvent.setText("Select...");
    allCategoriesEvent.setText("Select...");
  }

  /**
   * Handles the task button action by initializing and configuring the task popup window,
   * setting up task-related menu items and their actions, and adding the popup content
   */
  @FXML
  private void handleTaskButton() {
    try {
      this.taskPopup = new Popup();
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("taskPopup.fxml"));
      loader.setController(this);
      Scene s = loader.load();

      // Set up days_task menu items and actions
      daysTask.setOnAction(e -> {
        for (MenuItem menuItem : daysTask.getItems()) {
          menuItem.setOnAction(event -> {
            taskItems[0] = menuItem.getText();
            daysTask.setText(taskItems[0]);
          });
        }
      });
      // Set up completed menu items and actions
      completed.setOnAction(e -> {
        for (MenuItem menuItem : completed.getItems()) {
          menuItem.setOnAction(event -> {
            taskItems[1] = menuItem.getText();
            completed.setText(taskItems[1]);
          });
        }
      });
      // Set up all_categories_task menu items and actions
      allCategoriesTask.setOnAction(e -> {
        for (MenuItem menuItem : allCategoriesTask.getItems()) {
          menuItem.setOnAction(event -> {
            taskItems[2] = menuItem.getText();
            allCategoriesTask.setText(taskItems[2]);
          });
        }
      });
      // Set up x_task button action
      xxTask.setOnAction(e -> {
        clearTaskWhenDone();
        taskPopup.hide();
      });

      // Set up done_task button action
      doneTask.setOnAction(e -> handleDoneTask());
      taskPopup.getContent().add((Node) s.getRoot());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Clears the input fields and selected values in the task popup when the task is done.
   */
  private void clearTaskWhenDone() {
    taskName.clear();
    taskDescription.clear();
    daysTask.setText("Select...");
    completed.setText("Select...");
    allCategoriesTask.setText("Select...");
  }

  /**
   * Handles the done_task button action by creating a new Task object using the inputs
   */
  private void handleDoneTask() {
    Task newTask = createTaskFromPopupInput(taskItems[0], taskItems[1], taskItems[2]);
    if (newTask.getName() != null
        && newTask.getCategory() != null) {
      journal.addTask(newTask);
      checkMaxes();
      loadTasks();
      initTaskBar();
      handleProgressBars();
      clearTaskWhenDone();
      taskPopup.hide();
    }
  }


  /**
   * Creates a new Task object using the input from the task popup.
   *
   * @param day        The selected day for the task.
   * @param completion The selected completion status for the task.
   * @param category   The selected category for the task.
   * @return A new Task object with the specified properties.
   */
  @FXML
  private Task createTaskFromPopupInput(String day, String completion, String category) {
    String name = taskName.getText();
    String description = taskDescription.getText();
    boolean complete = completion.equals("Completed");
    Task newTask = new Task(name, description, day, category, complete);
    return newTask;
  }

  /**
   * Handles the category button action by initializing and configuring the category popup window
   */
  @FXML
  private void handleCategoryButton() {
    try {
      this.categoryPopup = new Popup();
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("categoryPopup.fxml"));
      loader.setController(this);
      Scene s = loader.load();
      // Set up x_category button action
      xxCategory.setOnAction(e -> {
        newCategory.clear();
        categoryPopup.hide();
      });
      // Set up done_category button action
      doneCategory.setOnAction(e -> handleDoneCategory());
      categoryPopup.getContent().add((Node) s.getRoot());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Displays the category popup window.
   */
  @FXML
  private void makeCategoryPopup() {
    this.categoryPopup.show(this.stage);
  }

  /**
   * Initializes the quotes and notes section by setting its text to the notes and quotes.
   */
  private void initQuotesNotes() {
    notesAndQuotes.setText(journal.getNotesQuotes());
  }

  /**
   * Handles the done_category button action by getting the inputs
   */
  private void handleDoneCategory() {
    String newCategory = this.newCategory.getText();
    if (newCategory != null) {
      journal.addCategory(newCategory);
      MenuItem newCategoryItem = new MenuItem(newCategory);
      allCategoriesEvent.getItems().add(newCategoryItem);
      allCategoriesTask.getItems().add(newCategoryItem);
      this.newCategory.clear();
      categoryPopup.hide();
    }
  }

  /**
   * Handles the save button action by checking maximum values, determining the output file,
   * either from the journal or by using a file chooser, setting the journal's file, and saving
   * the journal file.
   */
  private void handleSave() {
    checkMaxes();
    File outputFile = null;

    if (journal.getFile() != null) {
      outputFile = journal.getFile();
    } else {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Save Journal");
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Bujo Files",
          "*.bujo"));

      outputFile = fileChooser.showSaveDialog(null);
    }

    if (outputFile != null) {
      journal.setFile(outputFile);
      journal.saveFile();
    }
  }

  /**
   * Gets the total count of tasks.
   *
   * @param totalTasks The list of all tasks.
   * @return The total count of tasks.
   */
  private int getTotalTaskCount(List<Task> totalTasks) {
    int count = 0;
    for (Task task : totalTasks) {
      count++;
    }
    return count;
  }

  /**
   * Gets the percentage of completed tasks out of all tasks.
   *
   * @param totalTasks The list of all tasks.
   * @return The formatted percentage of completed tasks.
   */
  private String getTotalCompletedTasks(List<Task> totalTasks) {
    double completeCount = 0;
    double percent = 0;
    int total = journal.getAllTasks().size();
    for (Task task : totalTasks) {
      if (task.getComplete()) {
        completeCount++;
      }
    }
    if (total != 0) {
      percent = (completeCount / total) * 100;
    }
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    String formattedNumber = decimalFormat.format(percent);
    return String.valueOf(formattedNumber + "%");
  }

  /**
   * Gets the total count of events.
   *
   * @param totalEvent The list of all events.
   * @return The total count of events.
   */
  private String getTotalEventCount(List<Event> totalEvent) {
    int count = 0;
    for (Event event : totalEvent) {
      count++;
    }
    return String.valueOf(count);
  }


  private void initStatsBar() {
    int totalTasks = getTotalTaskCount(journal.getAllTasks());
    totalEvents.setText(getTotalEventCount(journal.getAllEvents()));
    this.totalTasks.setText(String.valueOf(totalTasks));
    taskPercent.setText(getTotalCompletedTasks(journal.getAllTasks()));
  }

  private void initMaxEventsAndTasks() {
    maxTasks.setText(String.valueOf(journal.getMaxTasks()));
    maxEvents.setText(String.valueOf(journal.getMaxEvents()));
  }

  @FXML
  private void checkMaxes() {
    if (journal.exceedsMaxTasks() || journal.exceedsMaxEvents()) {
      handleWarning();
      makeWarningPopup();
    } else {
      warningPopup.hide();
    }
  }

  /**
   * Makes the warning popup appear
   */
  @FXML
  private void makeWarningPopup() {
    this.warningPopup.show(this.stage);
  }

  /**
   * Handles the showing and action of the warning popup
   */
  private void handleWarning() {
    try {
      FXMLLoader loader =
          new FXMLLoader(getClass().getClassLoader().getResource("warning.fxml"));
      loader.setController(this);
      Scene s = loader.load();
      warningPopup.getContent().add((Node) s.getRoot());
      closeWarning.setOnAction(e -> warningPopup.hide());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Calculates the percentage of completed tasks out of all tasks.
   *
   * @param totalTasks The list of all tasks.
   * @return The percentage of completed tasks.
   */
  private double getDaysCompletedTasks(List<Task> totalTasks) {
    double total = 0.0;
    double completeCount = 0.0;
    double completed = 0.0;

    for (Task task : totalTasks) {
      total++;
      if (task.getComplete()) {
        completeCount++;
      }
    }
    if (total != 0) {
      completed = (completeCount / total);
    }
    return completed;
  }

  /**
   * Calculates the count of uncompleted tasks.
   *
   * @param totalTasks The list of all tasks.
   * @return The count of uncompleted tasks.
   */
  private String getUncompletedTasks(List<Task> totalTasks) {
    int notCompleteCount = 0;

    for (Task task : totalTasks) {
      if (!task.getComplete()) {
        notCompleteCount++;
      }
    }
    return String.valueOf(notCompleteCount);
  }

  /**
   * Updates the progress bars and task remaining labels for each day of the week based on
   * the completed tasks.
   */
  private void handleProgressBars() {
    sunProgress.setProgress(getDaysCompletedTasks(journal.getSunday().getTasks()));
    sunTasksRemaining.setText(getUncompletedTasks(journal.getSunday().getTasks()));
    monProgress.setProgress(getDaysCompletedTasks(journal.getMonday().getTasks()));
    monTasksRemaining.setText(getUncompletedTasks(journal.getMonday().getTasks()));
    tueProgress.setProgress(getDaysCompletedTasks(journal.getTuesday().getTasks()));
    tueTasksRemaining.setText(getUncompletedTasks(journal.getTuesday().getTasks()));
    wedProgress.setProgress(getDaysCompletedTasks(journal.getWednesday().getTasks()));
    wedTasksRemaining.setText(getUncompletedTasks(journal.getWednesday().getTasks()));
    thuProgress.setProgress(getDaysCompletedTasks(journal.getThursday().getTasks()));
    thuTasksRemaining.setText(getUncompletedTasks(journal.getThursday().getTasks()));
    friProgress.setProgress(getDaysCompletedTasks(journal.getFriday().getTasks()));
    friTasksRemaining.setText(getUncompletedTasks(journal.getFriday().getTasks()));
    satProgress.setProgress(getDaysCompletedTasks(journal.getSaturday().getTasks()));
    satTasksRemaining.setText(getUncompletedTasks(journal.getSaturday().getTasks()));
  }

  /**
   * Configures the background color selection buttons and updates the background color and
   * container styles accordingly.
   */
  private void setBackground() {
    blue.setOnAction(e -> {
      background.setStyle("-fx-background-color: #5eafff");
      updateAllContainers("-fx-background-color: #b8d6f5");
    });
    red.setOnAction(e -> {
      background.setStyle("-fx-background-color: #ff8c8c");
      updateAllContainers("-fx-background-color: #fac8c8");
    });
    purple.setOnAction(e -> {
      background.setStyle("-fx-background-color: #caa3ff");
      updateAllContainers("-fx-background-color: #eadcfc");
    });
    green.setOnAction(e -> {
      background.setStyle("-fx-background-color: #89b589");
      updateAllContainers("-fx-background-color: #cfe6cf");
    });
  }

  /**
   * Updates the style of all containers to the specified style string.
   *
   * @param string The style string to apply to all containers.
   */
  private void updateAllContainers(String string) {
    taskbarList.setStyle(string);
    notesAndQuotes.setStyle(string);
    sunEventsList.setStyle(string);
    sunTasksList.setStyle(string);
    monEventsList.setStyle(string);
    monTasksList.setStyle(string);
    tuesEventsList.setStyle(string);
    tuesTasksList.setStyle(string);
    wedEventsList.setStyle(string);
    wedTasksList.setStyle(string);
    thurEventsList.setStyle(string);
    thurTasksList.setStyle(string);
    friEventsList.setStyle(string);
    friTasksList.setStyle(string);
    satEventsList.setStyle(string);
    satTasksList.setStyle(string);
  }

}
