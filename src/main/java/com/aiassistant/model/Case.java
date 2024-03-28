package com.aiassistant.model;

import java.util.Date;

public class Case {
    private int id;
    private String caseType;
    private String caseTitle;
    private Date createTime;
    private String partyInfo;
    private String caseFact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPartyInfo() {
        return partyInfo;
    }

    public void setPartyInfo(String partyInfo) {
        this.partyInfo = partyInfo;
    }

    public String getCaseFact() {
        return caseFact;
    }

    public void setCaseFact(String caseFact) {
        this.caseFact = caseFact;
    }
}
