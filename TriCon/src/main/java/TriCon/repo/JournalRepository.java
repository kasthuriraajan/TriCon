package TriCon.repo;

import TriCon.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<Journal, String>
{

}
