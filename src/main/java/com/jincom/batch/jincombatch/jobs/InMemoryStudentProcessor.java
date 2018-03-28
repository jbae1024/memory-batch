package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * This custom {@code ItemProcessor} simply writes the information of the
 * processed student to the log and returns the processed object.
 *
 * @author Petri Kainulainen
 */
public class InMemoryStudentProcessor implements ItemProcessor<StudentDTO, StudentDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryStudentProcessor.class);

    @Override
    public StudentDTO process(StudentDTO item) throws Exception {
        LOGGER.info("진행중인 학생 정보 : {}", item);
        return item;
    }

}
