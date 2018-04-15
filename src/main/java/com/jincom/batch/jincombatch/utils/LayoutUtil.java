package com.jincom.batch.jincombatch.utils;

import com.jincom.batch.jincombatch.dto.MessageFooterVO;

import java.io.*;

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
public class LayoutUtil {


    private MessageFooterVO messageFooterVO;
    private File inputFile;

    public LayoutUtil() {
    }

    public LayoutUtil(File inputFile) throws IOException {

        this.inputFile = inputFile;

        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        MessageFooterVO messageFooterVO = null;
        String lineStr;
        while ((lineStr=bufferedReader.readLine())!= null){
            if(lineStr.substring(0,1).equals("E")){
                messageFooterVO = new MessageFooterVO(lineStr);
            }
        }

        this.messageFooterVO = messageFooterVO;
    }

    public MessageFooterVO getMessageFooterVO() {
        return messageFooterVO;
    }

    public void setMessageFooterVO(MessageFooterVO messageFooterVO) {
        this.messageFooterVO = messageFooterVO;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }
}
