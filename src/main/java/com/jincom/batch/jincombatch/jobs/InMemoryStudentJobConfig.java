package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.StudentDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Petri Kainulainen
 */
@Configuration
public class InMemoryStudentJobConfig {

    @Bean
    ItemReader<StudentDTO> inMemoryStudentReader() {
        return new InMemoryStudentReader();
    }

    @Bean
    ItemProcessor<StudentDTO, StudentDTO> inMemoryStudentProcessor() {
        return new InMemoryStudentProcessor();
    }

    @Bean
    ItemWriter<StudentDTO> inMemoryStudentWriter() {
        return new InMemoryStudentWriter();
    }

    @Bean
    Step inMemoryStudentStep(ItemReader<StudentDTO> inMemoryStudentReader,
                             ItemProcessor<StudentDTO, StudentDTO> inMemoryStudentProcessor,
                             ItemWriter<StudentDTO> inMemoryStudentWriter,
                             StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("inMemoryStudentStep")
                .<StudentDTO, StudentDTO>chunk(1)
                .reader(inMemoryStudentReader)
                .processor(inMemoryStudentProcessor)
                .writer(inMemoryStudentWriter)
                .build();
    }

    @Bean
    Job inMemoryStudentJob(JobBuilderFactory jobBuilderFactory,
                           @Qualifier("inMemoryStudentStep") Step inMemoryStudentStep) {
        return jobBuilderFactory.get("inMemoryStudentJob")
                .incrementer(new RunIdIncrementer())
                .flow(inMemoryStudentStep)
                .end()
                .build();
    }

}
