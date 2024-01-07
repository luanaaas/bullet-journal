package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents the JSON structure for button information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ButtonInfoJson(
    @JsonProperty("category") List<String> categories,
    @JsonProperty("maxTasks") int maxTasks,
    @JsonProperty("maxEvents") int maxEvents) {
}
