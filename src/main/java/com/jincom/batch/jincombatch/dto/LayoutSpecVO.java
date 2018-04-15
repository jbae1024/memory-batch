package com.jincom.batch.jincombatch.dto;

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
public class LayoutSpecVO {

    private String fileName;
    private String tableName;
    private int sortNo;
    private String colName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

}
