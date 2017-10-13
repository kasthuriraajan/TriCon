package TriCon.repo;

import TriCon.model.ProgressReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressReportRepository extends MongoRepository<ProgressReport,String> {
}
