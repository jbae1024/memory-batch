package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InMessageToDBReader implements ItemReader<MessageDTO> {
    private static final Logger LOGGER = LoggerFactory.getLogger(InMessageToDBReader.class);
    private int nextMessageDTOIndex;

    @Override
    public MessageDTO read() throws Exception{

        LOGGER.info("<Message File> Read Strat");
        String path="/Users/jinhwancom/Projects/memory-batch/src/main/resources/data/";
        File dirFile = new File(path);
        File[] fileList = dirFile.listFiles();
        System.out.println("1");
        for(File tempFile : fileList) {
            if(tempFile.isFile()){
                String tempPath = tempFile.getParent();
                String tempFileName = tempFile.getName();
                System.out.println("Path : "+tempPath);
                System.out.println("FileName : "+tempFileName);
            }
        }
        System.out.println("2");


        File filePath = new File("/Users/jinhwancom/Projects/memory-batch/src/main/resources/data/message.txt");
        FileReader fReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fReader);

        LOGGER.info("<Message File> line Read");
        List<String> lineAddList = new ArrayList<>();
        String lineStr;

        while ((lineStr=bufferedReader.readLine())!= null){
            lineAddList.add(lineStr);
        }
        bufferedReader.close();
        LOGGER.info("<Message File> 읽은 파일을 라인별로 리스트로 저장 ");
        LOGGER.info("<Message File> lineAddList : {}", lineAddList);
        LOGGER.info("<Message File> lineAddList 수 : {}", lineAddList.size());

        LOGGER.info("<Message File> line Array set");
        List<MessageDTO> products = new ArrayList<>();
        for(int i=0 ; i < lineAddList.size(); i++){
            String lineAddOne = lineAddList.get(i);
            System.out.println("lineAddOne"+lineAddOne);

            MessageDTO newLineAddOne = new MessageDTO();
            newLineAddOne.setMsgOneLine(lineAddOne);
            products.add(newLineAddOne);
            System.out.println("products"+products.get(i).getMsgOneLine());
        }

//        LOGGER.info("<Message File> 라인별 컬럼 생성 완료 ");
        LOGGER.info("<Message File> 라인별 컬럼 생성 전체 : {}",products);

        MessageDTO nextMessageDto = null;
        if(nextMessageDTOIndex<products.size()){
            nextMessageDto = products.get(nextMessageDTOIndex);
            nextMessageDTOIndex++;
        }

        LOGGER.info("<Message File> Read 완료 ");
        LOGGER.info("<Message File> Read : {}",nextMessageDto);

        return nextMessageDto;

    }
}
