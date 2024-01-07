package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalTime;

/**
 * Represents a JSON object that represents an event.
 * This record is used for JSON serialization and deserialization.
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("category") String category,
    @JsonProperty("start-time") String startTime,
    @JsonProperty("duration") int duration // represents the number of minutes
) {
}
