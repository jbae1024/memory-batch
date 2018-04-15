package com.jincom.batch.jincombatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;

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
public class AaaTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

//        String path="/Users/jinhwancom/Projects/memory-batch/src/main/resources/data/";
//
//        File dirFile = new File(path);
//        File[] fileList = dirFile.listFiles();
//
//        System.out.println("-------------------------------");
//
//        for(File tempFile : fileList) {
//
//            if("aaa.txt".equals(tempFile.getName())){
//                System.out.println(tempFile.getName());
//            }
////            if(tempFile.isFile()){
////                String tempPath = tempFile.getParent();
////                String tempFileName = tempFile.getName();
////                System.out.println("Path : "+tempPath);
////                System.out.println("FileName : "+tempFileName);
////            }
//        }

        return RepeatStatus.FINISHED;
    }
}
