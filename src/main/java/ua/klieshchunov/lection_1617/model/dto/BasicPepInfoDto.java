package ua.klieshchunov.lection_1617.model.dto;

import lombok.ToString;
import ua.klieshchunov.lection_1617.model.entity.Pep;

@ToString
public class BasicPepInfoDto implements PepDto{
    public String typeOfOfficial;
    public String firstName;
    public String lastName;
    public String firstNameEn;
    public String lastNameEn;
    public String url;
    public String dateOfBirth;

    public static BasicPepInfoDto toDto(Pep entity) {
        BasicPepInfoDto dto = new BasicPepInfoDto();
        dto.typeOfOfficial = entity.getTypeOfOfficial();
        dto.firstName = entity.getFirstName();
        dto.lastName = entity.getLastName();
        dto.firstNameEn = entity.getFirstNameEn();
        dto.lastNameEn = entity.getLastNameEn();
        dto.url = entity.getUrl();
        dto.dateOfBirth = entity.getDateOfBirth();
        return dto;
    }

    public static Pep toEntity(BasicPepInfoDto dto) {
        Pep entity = new Pep();
        entity.setTypeOfOfficial(dto.typeOfOfficial);
        entity.setFirstName(dto.firstName);
        entity.setLastName(dto.lastName);
        entity.setFirstNameEn(dto.firstNameEn);
        entity.setLastNameEn(dto.lastNameEn);
        entity.setUrl(dto.url);
        entity.setDateOfBirth(dto.dateOfBirth);
        return entity;
    }
}
