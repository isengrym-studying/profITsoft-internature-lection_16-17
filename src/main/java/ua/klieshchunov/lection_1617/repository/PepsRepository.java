package ua.klieshchunov.lection_1617.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.klieshchunov.lection_1617.model.dto.CommonPepNameDto;
import ua.klieshchunov.lection_1617.model.entity.Pep;

import java.util.List;

@Repository
public interface PepsRepository extends MongoRepository<Pep, Integer> {
    Pep findByFirstNameAndLastName(String firstName, String lastName);

    @Aggregation(pipeline = {
            "{'$match':{isPep:'true'}}",
            "{'$group':{_id:'$firstName', count: {$sum: 1}}}",
            "{'$sort': {count: -1}}",
            "{'$limit': 10}"
    })
    List<CommonPepNameDto> findMostCommonNames();
}
