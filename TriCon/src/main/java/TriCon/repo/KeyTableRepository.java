package TriCon.repo;

import TriCon.model.KeyTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeyTableRepository extends MongoRepository<KeyTable, String> {
}
