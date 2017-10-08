package TriCon.repo;


import TriCon.model.WeeklyReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeeklyReportRepository extends MongoRepository<WeeklyReport,String>
{

}
