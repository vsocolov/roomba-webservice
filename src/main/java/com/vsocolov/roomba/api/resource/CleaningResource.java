package com.vsocolov.roomba.api.resource;

import com.vsocolov.roomba.api.PathConstants.Resources;
import com.vsocolov.roomba.data.request.CleaningRequest;
import com.vsocolov.roomba.data.response.CleaningResponse;
import com.vsocolov.roomba.facade.CleaningFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path(value = Resources.CLEAN)
public class CleaningResource {

    @Autowired
    private CleaningFacade cleaningFacade;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CleaningResponse clean(@Valid final CleaningRequest request) {
        return cleaningFacade.cleanRoom(request);
    }
}
