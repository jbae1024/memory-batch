package com.jincom.batch.jincombatch.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <pre>
 * <b>History:</b>
 *    작성자 : jinhwancom, 1.0, 2018. 3. 28. Init
 * </pre>
 *
 * @author 최종 수정자
 * @version 1.0, 2018. 3. 28. Init
 * @see
 */
public class StudentDTO {

    private String emailAddress;
    private String name;
    private String purchasedPackage;

    public StudentDTO() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPurchasedPackage() {
        return purchasedPackage;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchasedPackage(String purchasedPackage) {
        this.purchasedPackage = purchasedPackage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("emailAddress", emailAddress)
                .append("name", name)
                .append("purchasedPackage", purchasedPackage)
                .toString();
    }

}
