package ua.klieshchunov.lection_1617.model.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIncludeProperties({"position_en", "url", "income", "region_uk", "office_en", "position_uk", "year",
        "office_uk", "region_en", "family_income"})
public class Declaration {
    @JsonProperty("position_en")
    private String positionEn;
    @JsonProperty("url")
    private String url;
    @JsonProperty("income")
    private String income;
    @JsonProperty("region_uk")
    private String regionUk;
    @JsonProperty("office_en")
    private String officeEn;
    @JsonProperty("position_uk")
    private String positionUk;
    @JsonProperty("year")
    private String year;
    @JsonProperty("office_uk")
    private String officeUk;
    @JsonProperty("region_en")
    private String regionEn;
    @JsonProperty("family_income")
    private String familyIncome;
}
