package com.vsocolov.roomba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RoombaWebserviceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(RoombaWebserviceApplication.class);
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(RoombaWebserviceApplication.class, args);
    }

}
