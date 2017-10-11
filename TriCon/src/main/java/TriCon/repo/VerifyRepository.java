package TriCon.repo;

import TriCon.model.Verify;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerifyRepository  extends MongoRepository<Verify, String> {
}
