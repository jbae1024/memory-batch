package com.jincom.batch.jincombatch.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class MessageFooterVO {

    private String baseDate;
    private String msgOneLine;
    private String status;

    public MessageFooterVO() {
    }

    public MessageFooterVO(String msgOneLine) {
        this.msgOneLine = msgOneLine;
        if(msgOneLine.substring(1,5).equals("0000")){
            this.status = "정상";
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("baseDate", baseDate)
                .append("msgOneLine", msgOneLine)
                .toString();
    }
}




