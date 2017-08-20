package TriCon.repo;

import TriCon.model.weeklyReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeeklyReportRepository extends MongoRepository<weeklyReport,String>
{

}
