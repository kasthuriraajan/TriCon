package TriCon.repo;

import TriCon.model.University;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String> {
}
