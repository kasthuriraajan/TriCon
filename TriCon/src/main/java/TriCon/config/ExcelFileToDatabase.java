/*
package TriCon.config;

import TriCon.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
@Configuration
public class ExcelFileToDatabase {
    @Bean
    ItemReader<Student> excelStudentReader() {
        PoiItemReader<Student> reader = new PoiItemReader<>();
        reader.setResource(new ClassPathResource("data/students.xlsx"));
        reader.setRowMapper(excelRowMapper());
        return reader;
    }

    private RowMapper<Student> excelRowMapper() {
        return new StudentExcelRowMapper();
    }
}
*/
