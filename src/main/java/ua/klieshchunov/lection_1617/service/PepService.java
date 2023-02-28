package ua.klieshchunov.lection_1617.service;

import org.springframework.web.multipart.MultipartFile;
import ua.klieshchunov.lection_1617.exception.InvalidFileException;
import ua.klieshchunov.lection_1617.exception.ToDtoConversionException;
import ua.klieshchunov.lection_1617.model.dto.CommonPepNameDto;
import ua.klieshchunov.lection_1617.model.dto.PepDto;
import ua.klieshchunov.lection_1617.model.entity.Pep;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PepService {
    void uploadFile(MultipartFile multipartFile) throws IOException, InvalidFileException;
    void saveAll(List<Pep> peps);
    void deleteAll();
    <T extends PepDto> T toPepDto(Class<T> cls, Pep entity) throws ToDtoConversionException;
    Optional<Pep> getByUkNameAndSurname(String firstName, String lastName);
    List<CommonPepNameDto> getMostCommonNamesUk();
}
