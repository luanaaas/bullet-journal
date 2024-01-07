# Program Pitch
Introducing a comprehensive productivity tool designed to help you stay organized and maximize your efficiency. You can:

* Create events with descriptions, time, day, and duration, ensuring that you never miss an important appointment.
* Manage tasks effortlessly, keeping track of your to-do list for each day.
* Capture inspiring quotes and important notes, providing a central place to store your thoughts.
* Customize the theme of the application with a choice of blue, red, purple, or green, allowing you to personalize your experience.
* Get an overview of the total number of events and tasks, giving you a clear picture of your commitments.
* Track your progress with a weekly percentage of completed tasks, motivating you to accomplish more.
* Monitor your daily progress through interactive progress bars, providing a visual representation of task completion.
* Open up an existing .bujo file, upload a .bujo templete, or start an empty file

Experience the convenience and efficiency of this bullet journal, and take control of your schedule like never before. Boost your productivity and achieve your goals effortlessly with this all-in-one productivity solution!

## How SOLID principles are applied in our project!:

1. **Single Responsibility Principle:** Each class in our project has a clear and specific responsibility: we have a separate class for managing an event, a task, a day, and a journal. We also make sure each of our methods holds one responsibility and delegates to needed helper methods.
2. **Open-Closed Principle:** Our project is designed to be open for extension but closed for modification. For instance,  in **`initButtons()`,** each button is associated with a specific action or functionality. If new buttons or actions need to be added in the future, the method can be extended by adding additional lines of code without modifying the existing code or behavior of the method, allowing for easy extension of the button functionality without the need to modify the existing code, promoting code maintainability and flexibility.
3. **Liskov Substitution Principle:** By designing an abstract class called **`AbstactCommitment`**, which serves as the superclass for two subclasses: **`Task`** and **`Event`** , we ensured that instances of **`Task`** and **`Event`** can be used interchangeably with instances of **`Commitment`** without impacting the correctness of the program.
4. **Interface Segregation Principle:** Our project follows ISP by providing interfaces for our controller, our model, and a commitment, allowing the code to be implemented or extended as desired.
5. **Dependency Inversion Principle:** our design implements loose coupling by calling instances of objects within other classes and uses abstraction to allow such loose coupling.
