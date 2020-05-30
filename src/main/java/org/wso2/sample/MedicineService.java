package org.wso2.sample;

import com.google.gson.Gson;
import org.wso2.sample.domain.MedicalRecord;
import org.wso2.sample.domain.Medicine;
import org.wso2.sample.domain.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/medicine")
public class MedicineService {

    private List<Medicine> medicines = new ArrayList<>();

    public MedicineService(){

        medicines.add(new Medicine("A1", "Augmentin"));
        medicines.add(new Medicine("N1", "Nurofen"));
        medicines.add(new Medicine("P1", "Piriton"));
        medicines.add(new Medicine("D1", "Digene"));
        medicines.add(new Medicine("P2", "Pantodac"));

    }

    @GET
    @Produces("application/json")
    public Response getAllMedicines() {
            return Response.status(Response.Status.OK).entity(new Gson().toJson(medicines)).build();
    }


}
