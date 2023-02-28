package ua.klieshchunov.lection_1617.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.klieshchunov.lection_1617.exception.InvalidFileException;
import ua.klieshchunov.lection_1617.exception.ToDtoConversionException;
import ua.klieshchunov.lection_1617.model.dto.CommonPepNameDto;
import ua.klieshchunov.lection_1617.model.dto.PepDto;
import ua.klieshchunov.lection_1617.model.dto.constant.DtoConstant;
import ua.klieshchunov.lection_1617.model.entity.Pep;
import ua.klieshchunov.lection_1617.repository.PepsRepository;
import ua.klieshchunov.lection_1617.service.PepService;
import ua.klieshchunov.lection_1617.service.UnzipService;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class PepServiceImpl implements PepService {
    private final PepsRepository pepsRepo;
    private final UnzipService unzipService;

    public PepServiceImpl(PepsRepository pepsRepo, UnzipService unzipService) {
        this.pepsRepo = pepsRepo;
        this.unzipService = unzipService;
    }

    @Override
    @Transactional
    public void uploadFile(MultipartFile multipartFile) throws IOException, InvalidFileException {
        if (multipartFile == null || multipartFile.isEmpty())
            throw new InvalidFileException("File is empty or null");

        this.deleteAll();
        byte[] bytes = unzipService.getUnzippedFileBytes(multipartFile);
        List<Pep> peps = convertBytesToPeps(bytes);
        this.saveAll(peps);
    }

    private static List<Pep> convertBytesToPeps(byte[] bytes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(bytes, new TypeReference<>() {});
    }

    @Override
    public void saveAll(List<Pep> peps) {
        pepsRepo.saveAll(peps);
    }

    @Override
    public void deleteAll() {
        pepsRepo.deleteAll();
    }

    @Override
    public <T extends PepDto> T toPepDto(Class<T> cls, Pep entity) throws ToDtoConversionException {
        try {
            Method method = cls.getMethod(DtoConstant.TO_DTO, entity.getClass());
            return (T) method.invoke(null, entity);
        } catch (Exception e) {
            throw new ToDtoConversionException(String.format("Couldn't invoke 'toDto' method on %s",cls.getName()), e);
        }
    }

    @Override
    public Optional<Pep> getByUkNameAndSurname(String firstName, String lastName) {
        return Optional.ofNullable(pepsRepo.findByFirstNameAndLastName(firstName, lastName));
    }

    @Override
    public List<CommonPepNameDto> getMostCommonNamesUk() {
        return pepsRepo.findMostCommonNames();
    }
}
