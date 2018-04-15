package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.MessageDTO;
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

@Configuration
public class TSB0008_InMessageToDB {
    @Bean
    ItemReader<MessageDTO> inMessageToDBReader() {
        return new InMessageToDBReader();
    }

    @Bean
    ItemProcessor<MessageDTO,MessageDTO> inMessageToDProcessor(){ return new InMessageToDProcessor();}

    @Bean
    ItemWriter<MessageDTO> inMessageToDWriter(){ return new InMessageToDWriter();}

    @Bean
    Step inMessageToDStep(ItemReader<MessageDTO> inMessageToDReader,
                          ItemProcessor<MessageDTO, MessageDTO> inMessageToDProcessor,
                          ItemWriter<MessageDTO> inMessageToDWriter,
                          StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("inMessageToDStep")
                .<MessageDTO, MessageDTO>chunk(100)
                .reader(inMessageToDReader)
                .processor(inMessageToDProcessor)
                .writer(inMessageToDWriter)
                .build();
    }

    @Bean
    Job inMessageToDJob(JobBuilderFactory jobBuilderFactory,
                        @Qualifier("inMessageToDStep") Step inMessageToDStep) {
        return jobBuilderFactory.get("inMessageToDJob")
                .incrementer(new RunIdIncrementer())
                .flow(inMessageToDStep)
                .end()
                .build();
    }
}
