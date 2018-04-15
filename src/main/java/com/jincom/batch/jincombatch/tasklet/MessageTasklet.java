package com.jincom.batch.jincombatch.tasklet;

import com.jincom.batch.jincombatch.dto.LayoutSpecVO;
import com.jincom.batch.jincombatch.dto.MessageDTO;
import com.jincom.batch.jincombatch.dto.MessageFooterVO;
import com.jincom.batch.jincombatch.dto.MessageHeaderVO;
import com.jincom.batch.jincombatch.utils.LayoutUtil;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
public class MessageTasklet implements Tasklet {

    @Autowired
    Environment environment;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

//        String path="/Users/jinhwancom/Projects/memory-batch/src/main/resources/data/";
//        String resourcePath = environment.getRequiredProperty("data/");

        File dirFile = new ClassPathResource("data/").getFile();
        File[] fileList = dirFile.listFiles();

        ArrayList<LayoutSpecVO> samples = new ArrayList<>();

        LayoutSpecVO layoutSpecVO = new LayoutSpecVO();
        layoutSpecVO.setTableName("message_spec");
        layoutSpecVO.setFileName("message.txt");
        layoutSpecVO.setSortNo(1);
        layoutSpecVO.setColName("id_co");
        samples.add(layoutSpecVO);

        layoutSpecVO.setTableName("aaa_spec");
        layoutSpecVO.setFileName("aaa.txt");
        layoutSpecVO.setSortNo(1);
        layoutSpecVO.setColName("aaa_co");
        samples.add(layoutSpecVO);

        ArrayList<MessageDTO> messageDTOs = new ArrayList<>();

        for(File tempFile : fileList) {
            if(tempFile.isFile()
                    && "message.txt".equals(tempFile.getName())){

                String lineStr;

                //BODY
                FileReader bodyReader = new FileReader(tempFile);
                BufferedReader bodyBufferedReader = new BufferedReader(bodyReader);

                while ((lineStr=bodyBufferedReader.readLine())!= null){

                    if(lineStr.substring(0,1).equals("D")){
                        MessageDTO messageDTO = new MessageDTO(lineStr, messageHeader(tempFile),
                                new LayoutUtil(tempFile).getMessageFooterVO());
                        messageDTOs.add(messageDTO);
                    }
//                    System.out.println(messageDTO.getDivide());
//                    MessageDTO messageDTO = new MessageDTO(lineStr);
//                    System.out.println(messageDTO.getDivide());
//                    MessageDTO messageDbDTO = new MessageDTO(samples);
//                    System.out.println(messageDbDTO.getDivide());
//                    messageDTOs.add(messageDTO);

                }
            }
        }

//        System.out.println(messageDTOs);
        return RepeatStatus.FINISHED;

    }

    private MessageHeaderVO messageHeader ( File tempFile )
            throws IOException {

        FileReader reader = new FileReader(tempFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        MessageHeaderVO messageHeaderVO = null;
        String lineStr;
        while ((lineStr=bufferedReader.readLine())!= null){
            if(lineStr.substring(0,1).equals("S")){
                messageHeaderVO = new MessageHeaderVO(lineStr);
            }
        }
        return messageHeaderVO;
    }

    private MessageFooterVO messageFooter ( File tempFile )
            throws IOException {

        FileReader reader = new FileReader(tempFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        MessageFooterVO messageFooterVO = null;
        String lineStr;
        while ((lineStr=bufferedReader.readLine())!= null){
            if(lineStr.substring(0,1).equals("E")){
                messageFooterVO = new MessageFooterVO(lineStr);
            }
        }
        return messageFooterVO;
    }


}
