package com.bs.einvoice.errorrecords.model;

import java.io.Serializable;

public class ErrorRecord implements Serializable {

    private static final long serialVersionUID = -1788199231038721040L;

    //主键 票据类型-票据代码-票据号码 ==> 反转
    private String id;

    //开票类型  1:开正常票  2:开红字票  3:打印纸票  4:取消打印
    private String issueType;

    //票据代码
    private String eInvoiceCode;

    //票据号码
    private String eInvoiceNumber;

    //待签名原文 待签名原文，XML格式
    private String eInvoiceContent;

    //单位签名值 Base64格式
    private String invoicingPartySignature;

    //签名算法
    private String signatureAlgorithm;

    //签名格式类型
    private String signatureType;

    //签名时间
    private String signatureTime;

    //证书编号
    private String serialNumber;

    //相关票据代码
    private String relatedInvoiceCode;

    //相关票据号码
    private String relatedInvoiceNumber;

    //单位是否签名
    private String invoicingPartyNoNeedSign;

    //错误类型
    private String errorType;

    //原因
    private String cause;

    //错误时间 yyyy-MM-dd HH:mm:ss
    private String errorTime;

    //补偿计数
    private int compensationCount;

    //开票参数
    private String issueParam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String geteInvoiceCode() {
        return eInvoiceCode;
    }

    public void seteInvoiceCode(String eInvoiceCode) {
        this.eInvoiceCode = eInvoiceCode;
    }

    public String geteInvoiceNumber() {
        return eInvoiceNumber;
    }

    public void seteInvoiceNumber(String eInvoiceNumber) {
        this.eInvoiceNumber = eInvoiceNumber;
    }

    public String geteInvoiceContent() {
        return eInvoiceContent;
    }

    public void seteInvoiceContent(String eInvoiceContent) {
        this.eInvoiceContent = eInvoiceContent;
    }

    public String getInvoicingPartySignature() {
        return invoicingPartySignature;
    }

    public void setInvoicingPartySignature(String invoicingPartySignature) {
        this.invoicingPartySignature = invoicingPartySignature;
    }

    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public String getSignatureTime() {
        return signatureTime;
    }

    public void setSignatureTime(String signatureTime) {
        this.signatureTime = signatureTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRelatedInvoiceCode() {
        return relatedInvoiceCode;
    }

    public void setRelatedInvoiceCode(String relatedInvoiceCode) {
        this.relatedInvoiceCode = relatedInvoiceCode;
    }

    public String getRelatedInvoiceNumber() {
        return relatedInvoiceNumber;
    }

    public void setRelatedInvoiceNumber(String relatedInvoiceNumber) {
        this.relatedInvoiceNumber = relatedInvoiceNumber;
    }

    public String getInvoicingPartyNoNeedSign() {
        return invoicingPartyNoNeedSign;
    }

    public void setInvoicingPartyNoNeedSign(String invoicingPartyNoNeedSign) {
        this.invoicingPartyNoNeedSign = invoicingPartyNoNeedSign;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }

    public int getCompensationCount() {
        return compensationCount;
    }

    public void setCompensationCount(int compensationCount) {
        this.compensationCount = compensationCount;
    }

    public String getIssueParam() {
        return issueParam;
    }

    public void setIssueParam(String issueParam) {
        this.issueParam = issueParam;
    }

    @Override
    public String toString() {
        return "EInvoiceErrorRecord{" +
                "id='" + id + '\'' +
                ", issueType='" + issueType + '\'' +
                ", eInvoiceCode='" + eInvoiceCode + '\'' +
                ", eInvoiceNumber='" + eInvoiceNumber + '\'' +
                ", eInvoiceContent='" + eInvoiceContent + '\'' +
                ", invoicingPartySignature='" + invoicingPartySignature + '\'' +
                ", signatureAlgorithm='" + signatureAlgorithm + '\'' +
                ", signatureType='" + signatureType + '\'' +
                ", signatureTime='" + signatureTime + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", relatedInvoiceCode='" + relatedInvoiceCode + '\'' +
                ", relatedInvoiceNumber='" + relatedInvoiceNumber + '\'' +
                ", invoicingPartyNoNeedSign='" + invoicingPartyNoNeedSign + '\'' +
                ", errorType='" + errorType + '\'' +
                ", cause='" + cause + '\'' +
                ", errorTime='" + errorTime + '\'' +
                ", compensationCount=" + compensationCount +
                ", issueParam='" + issueParam + '\'' +
                '}';
    }
}
