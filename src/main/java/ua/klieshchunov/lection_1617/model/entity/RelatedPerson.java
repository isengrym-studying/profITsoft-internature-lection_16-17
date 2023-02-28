package ua.klieshchunov.lection_1617.model.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIncludeProperties({"relationship_type_en", "date_established", "person_en", "date_confirmed", "is_pep",
        "date_finished", "person_uk", "relationship_type"})
public class RelatedPerson {
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("date_established")
    private String dateEstablished;
    @JsonProperty("person_en")
    private String personEn;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    @JsonProperty("is_pep")
    private String isPep;
    @JsonProperty("date_finished")
    private String dateFinished;
    @JsonProperty("person_uk")
    private String personUk;
    @JsonProperty("relationship_type")
    private String relationshipType;
}
