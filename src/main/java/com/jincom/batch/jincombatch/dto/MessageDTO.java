package com.jincom.batch.jincombatch.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class MessageDTO {

    //BODY
    private String divide;
    private String bankBranchNo;
    private String custNo;
    private String transferDate;
    private String transferAmount;
    private String sendCondition;
    private String msgOneLine;

    //HEADER
    private MessageHeaderVO messageHeaderVO;

    //FOOTER
    private MessageFooterVO messageFooterVO;

    private LayoutSpecVO layoutSpecVO;

    private ArrayList<LayoutSpecVO> layoutSpecVOs;

    public MessageDTO() {

    }

    public MessageDTO(String msgOneLine) {
        this.msgOneLine = msgOneLine;
        this.divide = this.msgOneLine.substring(0, 5);
        this.bankBranchNo = this.msgOneLine.substring(6, 7);
    }

    public MessageDTO( String msgOneLine, MessageHeaderVO messageHeaderVO ) {

        this.msgOneLine = msgOneLine;
        this.messageHeaderVO = messageHeaderVO;

        System.out.println(messageHeaderVO.getBaseDate()+"|"+msgOneLine);

    }

    public MessageDTO(String msgOneLine, MessageHeaderVO messageHeaderVO, MessageFooterVO messageFooterVO) {
        this.msgOneLine = msgOneLine;
        this.messageHeaderVO = messageHeaderVO;
        this.messageFooterVO = messageFooterVO;

        System.out.println(messageHeaderVO.getBaseDate()+"|"+msgOneLine+"|"+messageFooterVO.getStatus());

    }

    public MessageDTO(LayoutSpecVO layoutSpecVO) {
        this.layoutSpecVO = layoutSpecVO;
    }

    public MessageDTO(ArrayList<LayoutSpecVO> layoutSpecVOs) {

        this.layoutSpecVOs = layoutSpecVOs;

        for(LayoutSpecVO layoutSpecVO : layoutSpecVOs ){
            if(layoutSpecVO.getFileName().equals("message.txt")){
                if(layoutSpecVO.getColName().equals("divide")){
                    this.divide = this.msgOneLine.substring(0, 5);
                }
                if(layoutSpecVO.getColName().equals("bankBranchNo")){
                    this.bankBranchNo = this.msgOneLine.substring(5, 6);
                }
            }
        }

    }

    public MessageFooterVO getMessageFooterVO() {
        return messageFooterVO;
    }

    public void setMessageFooterVO(MessageFooterVO messageFooterVO) {
        this.messageFooterVO = messageFooterVO;
    }

    public MessageHeaderVO getMessageHeaderVO() {
        return messageHeaderVO;
    }

    public void setMessageHeaderVO(MessageHeaderVO messageHeaderVO) {
        this.messageHeaderVO = messageHeaderVO;
    }

    public LayoutSpecVO getLayoutSpecVO() {
        return layoutSpecVO;
    }

    public void setLayoutSpecVO(LayoutSpecVO layoutSpecVO) {
        this.layoutSpecVO = layoutSpecVO;
    }

    public ArrayList<LayoutSpecVO> getLayoutSpecVOs() {
        return layoutSpecVOs;
    }

    public void setLayoutSpecVOs(ArrayList<LayoutSpecVO> layoutSpecVOs) {
        this.layoutSpecVOs = layoutSpecVOs;
    }

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


        System.out.println("case2 | "+messageHeaderVO.getBaseDate()+"|"+msgOneLine);


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




