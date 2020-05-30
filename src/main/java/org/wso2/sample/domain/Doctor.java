package org.wso2.sample.domain;

import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement
public class Doctor {

    @XmlElement(name = "id")
    private String id;
    private String name;

    public Doctor(){
        id = UUID.randomUUID().toString();
    }

    public Doctor(String name){
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
