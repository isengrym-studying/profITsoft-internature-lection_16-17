package ua.klieshchunov.lection_1617.model.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIncludeProperties({"date_established", "date_finished", "date_confirmed", "to_country_en", "to_country_uk",
        "relationship_type", "declarations", ""})
public class RelatedCountry {
    @JsonProperty("date_established")
    private String dateEstablished;
    @JsonProperty("date_finished")
    private String dateFinished;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    @JsonProperty("to_country_en")
    private String toCountryEn;
    @JsonProperty("to_country_uk")
    private String toCountryUk;
    @JsonProperty("relationship_type")
    private String relationshipType;
    @JsonProperty("declarations")
    private List<Declaration> declarations;
}
