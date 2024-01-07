package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a JSON object that stores the journal data.
 */
public record JournalJson(
    @JsonProperty("weekdays") List<DayJson> allDays,
    @JsonProperty("overview") OverviewJson overview,
    @JsonProperty("buttonInfo") ButtonInfoJson buttonInfo,
    @JsonProperty("quotesNotes") QuotesAndNotesJson quotesNotes
) {
}
