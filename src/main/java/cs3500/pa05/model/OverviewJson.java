package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an overview of the journal data, including the total number of events and tasks.
 */
public record OverviewJson(
    @JsonProperty("totalEvents") int totalEvents,
    @JsonProperty("totalTasks") int totalTasks
) {
}
