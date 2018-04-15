package com.jincom.batch.jincombatch.tasklet;

import com.jincom.batch.jincombatch.dto.MessageDTO;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * <pre>
 * <b>History:</b>
 *    작성자 : jinhwancom, 1.0, 2018. 4. 15. Init
 * </pre>
 *
 * @author 최종 수정자
 * @version 1.0, 2018. 4. 15. Init
 * @see
 */
public class FindFileTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        return null;
    }
}
