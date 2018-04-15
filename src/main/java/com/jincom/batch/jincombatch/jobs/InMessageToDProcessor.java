package com.jincom.batch.jincombatch.jobs;

import com.jincom.batch.jincombatch.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class InMessageToDProcessor implements ItemProcessor< MessageDTO , MessageDTO> {
    private static final Logger LOGGER = LoggerFactory.getLogger(InMessageToDProcessor.class);
    @Override
    public MessageDTO process(MessageDTO item) throws Exception {
        LOGGER.info("진행중인 전문 정보 : {}", item);
        return item;

    }
}
