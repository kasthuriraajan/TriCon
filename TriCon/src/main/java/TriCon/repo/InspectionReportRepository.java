package TriCon.repo;

import TriCon.model.InspectionReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectionReportRepository extends MongoRepository<InspectionReportRepository, String> {
}
