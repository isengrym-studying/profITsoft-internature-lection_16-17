package ua.klieshchunov.lection_1617.model.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "peps")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIncludeProperties({"type_of_official", "first_name", "last_name", "related_persons", "is_pep", "photo",
        "full_name_en", "first_name_en", "last_name_en", "url", "date_of_birth",
        "full_name", "patronymic", "patronymic_en", "died", "also_known_as_en", "names", "last_job_title",
        "last_workplace_en", "type_of_official_en", "related_companies", "related_countries", "last_job_title_en",
        "reputation_manhunt_en", "reputation_manhunt_uk"})
public class Pep {
    @JsonProperty("type_of_official")
    private String typeOfOfficial;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("related_persons")
    private List<RelatedPerson> relatedPeople;
    @JsonProperty("is_pep")
    private String isPep;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("full_name_en")
    private String fullNameEn;
    @JsonProperty("first_name_en")
    private String firstNameEn;
    @JsonProperty("last_name_en")
    private String lastNameEn;
    @JsonProperty("url")
    private String url;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("type_of_official_en")
    private String typeOfOfficialEn;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("patronymic_en")
    private String patronymicEn;
    @JsonProperty("died")
    private String died;
    @JsonProperty("also_known_as_en")
    private String alsoKnownAsEn;
    @JsonProperty("names")
    private String names;
    @JsonProperty("last_job_title")
    private String lastJobTitle;
    @JsonProperty("last_workplace_en")
    private String lastWorkplaceEn;
    @JsonProperty("related_companies")
    private List<RelatedCompany> relatedCompanies;
    @JsonProperty("related_countries")
    private List<RelatedCountry> relatedCountries;
    @JsonProperty("last_job_title_en")
    private String lastJobTitleEn;
    @JsonProperty("reputation_manhunt_en")
    private String reputationManhuntEn;
    @JsonProperty("reputation_manhunt_uk")
    private String reputationManhuntUk;
}
