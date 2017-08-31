package TriCon.repo;


import TriCon.model.Lecturer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LecturerRepository extends MongoRepository<Lecturer, String> {
}
