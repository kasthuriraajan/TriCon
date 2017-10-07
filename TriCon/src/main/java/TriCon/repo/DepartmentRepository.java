package TriCon.repo;

import TriCon.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department,String>{
    List<Department> findByid(String id);
}
