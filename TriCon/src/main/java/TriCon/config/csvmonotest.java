/*
package TriCon.config;

import TriCon.model.Student;
import TriCon.repo.StudentRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableBatchProcessing
@Configuration
public class csvmonotest {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private MongoTemplate mongoTemplate;
   @ Autowired
private StudentRepository studentRepository;

    @Bean
    public Job readCSVFile() {
        return jobBuilderFactory.get("readCSVFile").incrementer(new RunIdIncrementer()).start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Student, Student>chunk(10).reader(reader())
                .writer(writer()).build();
    }

    @Bean
    public FlatFileItemReader<Student> reader(String a) {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(a));
        reader.setLineMapper(new DefaultLineMapper<Student>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"Id", "FirstName","LastName","RegNo","DeptNo","DeptName","University","Email"});

            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                setTargetType(Student.class);
            }});
        }});
        return reader;
    }

    */
/*@Bean
    public MongoItemWriter<Student> writer() {
        MongoItemWriter<Student> writer = new MongoItemWriter<Student>();
        Student student = new Student();

        student.setId(rowSet.getColumnValue(0));
        student.setFirstName(rowSet.getColumnValue(1));
        student.setLastName(rowSet.getColumnValue(2));
        student.setRegNo();
        student.setDeptNo();
        student.setDeptName();
        student.setUniversity();
        student.setEmail();
        writer.setCollection("domain");
        return writer;
    }*//*

    @Bean
    public MongoItemWriter<Student> writer() {
        MongoItemWriter<Student> writer = new MongoItemWriter<Student>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("student");
        return writer;
    }

}
*/
