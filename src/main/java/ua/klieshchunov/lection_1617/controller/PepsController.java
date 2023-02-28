package ua.klieshchunov.lection_1617.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.klieshchunov.lection_1617.controller.constant.RequestParamConstant;
import ua.klieshchunov.lection_1617.exception.FileUploadException;
import ua.klieshchunov.lection_1617.exception.PepNotFoundException;
import ua.klieshchunov.lection_1617.exception.ToDtoConversionException;
import ua.klieshchunov.lection_1617.model.dto.BasicPepInfoDto;
import ua.klieshchunov.lection_1617.model.dto.CommonPepNameDto;
import ua.klieshchunov.lection_1617.model.dto.PepDto;
import ua.klieshchunov.lection_1617.model.entity.Pep;
import ua.klieshchunov.lection_1617.service.PepService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peps")
public class PepsController {
    private final PepService pepService;

    public PepsController(PepService pepService) {
        this.pepService = pepService;
    }

    @PostMapping
    public HttpStatus uploadPeps(@RequestParam(value = RequestParamConstant.FILE, required = false) MultipartFile multipartFile)
            throws FileUploadException {
        try {
            pepService.uploadFile(multipartFile);
        } catch (Exception e) {
            throw new FileUploadException("Couldn't upload file");
        }

        return HttpStatus.OK;
    }

    @GetMapping
    public ResponseEntity<PepDto> getPep(@RequestParam(value = RequestParamConstant.FIRST_NAME, defaultValue = "", required = false) String firstName,
                                         @RequestParam(value = RequestParamConstant.LAST_NAME, defaultValue = "", required = false) String lastName)
            throws ToDtoConversionException, PepNotFoundException {
        Optional<Pep> pepOptional = pepService.getByUkNameAndSurname(firstName, lastName);

        if (pepOptional.isPresent())
            return new ResponseEntity<>(pepService.toPepDto(BasicPepInfoDto.class, pepOptional.get()), HttpStatus.OK);

        throw new PepNotFoundException(
                String.format("Couldn't find pep with firstName='%s' and lastName='%s'", firstName, lastName)
        );
    }

    @GetMapping("/statistic")
    public ResponseEntity<List<CommonPepNameDto>> getPepsCommonNames() {
        return new ResponseEntity<>(pepService.getMostCommonNamesUk(), HttpStatus.OK);
    }

}