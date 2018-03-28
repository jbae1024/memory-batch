package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * This custom {@code ItemWriter} writes the information of the student to
 * the log.
 *
 * @author Petri Kainulainen
 */
public class InMemoryStudentWriter implements ItemWriter<StudentDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryStudentWriter.class);

    @Override
    public void write(List<? extends StudentDTO> items) throws Exception {

        LOGGER.info("저장할 학생 아이템 {}개", items.size());

        for( StudentDTO item : items ){
            LOGGER.info("DB 저장 go go : {}", item);
        }

    }
}