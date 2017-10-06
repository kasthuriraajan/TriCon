package TriCon.repo;

import TriCon.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student, String> {
List<Student>findStudentByRegNo(String RegNo);
}
