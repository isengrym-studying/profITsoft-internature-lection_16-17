package ua.klieshchunov.lection_1617.model.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIncludeProperties({"relationship_type_en", "to_company_short_en", "date_established", "to_company_edrpou",
        "to_company_founded", "date_finished", "to_company_is_state", "share", "date_confirmed", "to_company_uk",
        "to_company_short_uk", "to_company_en", "relationship_type_uk"})
public class RelatedCompany {
    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;
    @JsonProperty("to_company_short_en")
    private String toCompanyShortEn;
    @JsonProperty("date_established")
    private String datEstablished;
    @JsonProperty("to_company_edrpou")
    private String toCompanyEdrpou;
    @JsonProperty("to_company_founded")
    private String toCompanyFounded;
    @JsonProperty("date_finished")
    private String dateFinished;
    @JsonProperty("to_company_is_state")
    private String toCompanyIsState;
    @JsonProperty("share")
    private String share;
    @JsonProperty("date_confirmed")
    private String dateConfirmed;
    @JsonProperty("to_company_uk")
    private String toCompanyUk;
    @JsonProperty("to_company_short_uk")
    private String toCompanyShortUk;
    @JsonProperty("to_company_en")
    private String toCompanyEn;
    @JsonProperty("relationship_type_uk")
    private String relationshipTypeUk;
}
