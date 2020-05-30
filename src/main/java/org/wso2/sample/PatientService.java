package org.wso2.sample;

import com.google.gson.Gson;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import org.wso2.sample.domain.Patient;
import org.wso2.sample.domain.MedicalRecord;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/patient")
public class PatientService {

    private Map<String, Patient> patients = new HashMap<>();


    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getPatient(@PathParam("id") String id) {
        Patient patient = patients.get(id);

        if(patient != null){
            return Response.status(Response.Status.OK).entity(new Gson().toJson(patient)).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/search")
    @Produces("application/json")
    public Response searchPatient(@QueryParam("email") String email) {

        Patient patient = null;

        for(Map.Entry<String, Patient> entry : patients.entrySet()){
            if(entry.getValue().getEmail().equals(email)){
                patient = entry.getValue();
            }
        }

        if(patient != null){
            return Response.status(Response.Status.OK).entity(new Gson().toJson(patient)).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPatient(Patient patient){
        patients.put(patient.getId(), patient);
        return Response.status(Response.Status.OK).entity("{\"id\":\"" + patient.getId() + "\"}").build();
    }

    @POST
    @Path("/{id}/history")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addMedicalRecord(@PathParam("id") String id, MedicalRecord medicalRecord){
        Patient patient = patients.get(id);
        patient.addMedicalRecord(medicalRecord);
        return Response.status(Response.Status.OK).entity("{\"id\":\"" + medicalRecord.getId() + "\"}").build();
    }

    @DELETE
    @Path("/{patientId}/history/{recordId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteMedicalRecord(@PathParam("patientId") String patientId, @PathParam("recordId") String recordId){
        Patient patient = patients.get(patientId);
        patient.removeMedicalRecord(recordId);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response addPatient(@PathParam("id") String id){
        patients.remove(id);
        return Response.status(Response.Status.OK).build();
    }

}
