package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the quotes and notes data in the journal.
 */
public record QuotesAndNotesJson(
    @JsonProperty("quotesNotes") String quotesNotes
) {}
