package org.wso2.sample;

import com.google.gson.Gson;
import org.wso2.sample.domain.Doctor;
import org.wso2.sample.domain.Doctors;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/doctorService")
public class DoctorService {

    private List<Doctor> doctors = new ArrayList<>();

    public DoctorService(){

        doctors.add(new Doctor("Strange"));
        doctors.add(new Doctor("Ultron"));
        doctors.add(new Doctor("Falcon"));
        doctors.add(new Doctor("Hawkeye"));
        doctors.add(new Doctor("Nick"));


    }

    @GET
    @Path("/getAllDoctors")
    @Produces("application/xml")
    public Doctors getAllDoctors() {

        return new Doctors(doctors);
    }


}
