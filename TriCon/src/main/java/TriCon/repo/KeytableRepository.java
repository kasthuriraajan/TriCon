package TriCon.repo;

import TriCon.model.Keytable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeytableRepository extends MongoRepository<Keytable, String> {
}
