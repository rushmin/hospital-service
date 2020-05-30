package org.wso2.sample.domain;

import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctors {

    @XmlElement(name = "doctor")
    private Collection<Doctor> doctors;

    public Doctors(){

    }

    public Doctors(Collection<Doctor> doctors) {

        this.doctors = doctors;
    }

    public Collection<Doctor> getDoctors() {

        return this.doctors;
    }
}
