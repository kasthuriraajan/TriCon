package TriCon.repo;

import TriCon.model.AccessTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessTableRepository extends MongoRepository<AccessTable, String> {
}
