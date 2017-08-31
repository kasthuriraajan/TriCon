package TriCon.repo;

import TriCon.model.Industrialist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndustrialistRepository extends MongoRepository<Industrialist,String>{
}
