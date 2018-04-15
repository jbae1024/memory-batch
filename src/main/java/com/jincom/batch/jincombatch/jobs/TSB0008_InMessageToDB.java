package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.MessageDTO;
import com.jincom.batch.jincombatch.tasklet.AaaTasklet;
import com.jincom.batch.jincombatch.tasklet.BbbTasklet;
import com.jincom.batch.jincombatch.tasklet.FindFileTasklet;
import com.jincom.batch.jincombatch.tasklet.MessageTasklet;
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
    FindFileTasklet findFileTasklet(){
        return new FindFileTasklet();
    }

    @Bean
    Step findFileStep(StepBuilderFactory stepBuilderFactory,
                      FindFileTasklet findFileTasklet){

        return stepBuilderFactory.get("findFileStep")
                .tasklet(findFileTasklet)
                .build();
    }


//    @Bean
//    Job inMessageToDJob(JobBuilderFactory jobBuilderFactory,
//                        @Qualifier("findFileStep") Step findFileStep,
//                        @Qualifier("inMessageToDStep") Step inMessageToDStep) {
//
//        return jobBuilderFactory.get("inMessageToDJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(findFileStep)
//                .next(inMessageToDStep)
//                .end()
//                .build();
//
//    }

    ////
    @Bean
    MessageTasklet messageTasklet(){
        return new MessageTasklet();
    }

    @Bean
    AaaTasklet aaaTasklet(){
        return new AaaTasklet();
    }

    @Bean
    BbbTasklet bbbTasklet(){
        return new BbbTasklet();
    }


    @Bean
    Step messageStep(StepBuilderFactory stepBuilderFactory,
                     @Qualifier("inMessageToDStep") Step inMessageToDStep,
                     MessageTasklet messageTasklet){

        return stepBuilderFactory.get("messageStep")
                .tasklet(messageTasklet)
                .build();

    }


    @Bean
    Step aaaStep(StepBuilderFactory stepBuilderFactory,
                 AaaTasklet aaaTasklet){
        return stepBuilderFactory.get("aaaStep")
                .tasklet(aaaTasklet)
                .build();
    }

    @Bean
    Step bbbStep(StepBuilderFactory stepBuilderFactory,
                 BbbTasklet bbbTasklet){
        return stepBuilderFactory.get("bbbStep")
                .tasklet(bbbTasklet)
                .build();
    }


    @Bean
    Job hanaJob(JobBuilderFactory jobBuilderFactory,
                Step messageStep,
                Step aaaStep,
                Step bbbStep) {

        return jobBuilderFactory.get("hanaJob")
                .incrementer(new RunIdIncrementer())
                .flow(messageStep)
                .next(aaaStep)
                .next(bbbStep)
                .end()
                .build();

    }








}
