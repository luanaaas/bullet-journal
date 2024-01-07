package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;

/**
 * Represents a JSON representation of a task.
 */
public record TaskJson(

    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("category") String category,
    @JsonProperty("completed") boolean completed
) {
}
