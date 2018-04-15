package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class InMessageToDWriter implements ItemWriter<MessageDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMessageToDWriter.class);

    @Override
    public void write(List<? extends MessageDTO> items) throws Exception{

        LOGGER.info("저장할 전문 아이템 {}개", items.size());

        for( MessageDTO item : items ){
            LOGGER.info("DB 저장 go go : {}", item);
        }

    }
}
