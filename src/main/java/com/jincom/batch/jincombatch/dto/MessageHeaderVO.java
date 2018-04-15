package com.jincom.batch.jincombatch.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class MessageHeaderVO {

    private String baseDate;
    private String msgOneLine;

    public MessageHeaderVO() {
    }

    public MessageHeaderVO(String msgOneLine) {
        this.msgOneLine = msgOneLine;
        this.baseDate = msgOneLine.substring(1,9);
    }

    public String getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public String getMsgOneLine() {
        return msgOneLine;
    }

    public void setMsgOneLine(String msgOneLine) {
        this.msgOneLine = msgOneLine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("baseDate", baseDate)
                .append("msgOneLine", msgOneLine)
                .toString();
    }
}




