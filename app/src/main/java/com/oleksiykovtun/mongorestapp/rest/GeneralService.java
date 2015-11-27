package com.oleksiykovtun.mongorestapp.rest;

import com.oleksiykovtun.mongorestapp.Api;
import com.oleksiykovtun.mongorestapp.util.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The general backend REST service.
 */
@Path(Api.GENERAL)
public class GeneralService {

    protected static final String CHARSET_UTF_8 = ";charset=utf-8";
    protected static final String JSON = MediaType.APPLICATION_JSON + CHARSET_UTF_8;
    protected static final String TEXT = MediaType.TEXT_PLAIN + CHARSET_UTF_8;
    protected static final String JPEG = "image/jpeg";

    private static final String DEFAULT_MESSAGE = "This is the default message.";

    @GET
    @Path(Api.EMPTY)
    @Produces(TEXT)
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @GET
    @Path(Api.PING)
    @Produces(JSON)
    public String ping() {
        return "Pong: " + Time.getFullDateTimeNow();
    }

}
