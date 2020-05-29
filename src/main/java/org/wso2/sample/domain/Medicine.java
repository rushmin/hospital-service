package org.wso2.sample.domain;

public class Medicine {

    private String code;
    private String name;

    public Medicine(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
