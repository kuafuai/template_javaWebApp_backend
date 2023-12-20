package com.aiassistant.model;

import lombok.Data;

@Data
public class Cable {

    private Integer id;
    private String projectNumber;
    private String productCode;
    private String productName;
    private String componentCode;
    private String cableSpecification;
    private String lineNumber;
    private String length;
    private String leftPeelOuter;
    private String leftPeelInner;
    private String rightPeelOuter;
    private String rightPeelInner;
    private String sprayCode;
    private String leftPeelOuterProcess;
    private String leftShieldProcess;
    private String leftPeelInnerProcess;
    private String rightPeelOuterProcess;
    private String rightShieldProcess;
    private String rightPeelInnerProcess;
    private Boolean isDefault;
    private String versionNumber;

    private int start;
    private int limit;
}
