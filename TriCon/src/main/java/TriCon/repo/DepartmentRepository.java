package TriCon.repo;

import TriCon.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department,String>{
}
