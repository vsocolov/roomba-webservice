package com.vsocolov.roomba.api;

import com.vsocolov.roomba.api.resource.CleaningResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(PathConstants.ROOT_PATH)
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerClasses(CleaningResource.class);
    }
}
