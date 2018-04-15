package com.jincom.batch.jincombatch.dto;

import java.util.Objects;

public class MessageDTO {
    private String divide;
    private String bankBranchNo;
    private String custNo;
    private String transferDate;
    private String transferAmount;
    private String sendCondition;
    private String msgOneLine;

    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide;
    }

    public String getBankBranchNo() {
        return bankBranchNo;
    }

    public void setBankBranchNo(String bankBranchNo) {
        this.bankBranchNo = bankBranchNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getSendCondition() {
        return sendCondition;
    }

    public void setSendCondition(String sendCondition) {
        this.sendCondition = sendCondition;
    }

    public String getMsgOneLine() {
        return msgOneLine;
    }

    public void setMsgOneLine(String msgOneLine) {
        this.msgOneLine = msgOneLine;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "divide='" + divide + '\'' +
                ", bankBranchNo='" + bankBranchNo + '\'' +
                ", custNo='" + custNo + '\'' +
                ", transferDate='" + transferDate + '\'' +
                ", transferAmount='" + transferAmount + '\'' +
                ", sendCondition='" + sendCondition + '\'' +
                ", msgOneLine='" + msgOneLine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDTO that = (MessageDTO) o;
        return Objects.equals(divide, that.divide) &&
                Objects.equals(bankBranchNo, that.bankBranchNo) &&
                Objects.equals(custNo, that.custNo) &&
                Objects.equals(transferDate, that.transferDate) &&
                Objects.equals(transferAmount, that.transferAmount) &&
                Objects.equals(sendCondition, that.sendCondition) &&
                Objects.equals(msgOneLine, that.msgOneLine);
    }

    @Override
    public int hashCode() {

        return Objects.hash(divide, bankBranchNo, custNo, transferDate, transferAmount, sendCondition, msgOneLine);
    }
}




