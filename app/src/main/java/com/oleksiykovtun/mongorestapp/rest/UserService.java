package com.oleksiykovtun.mongorestapp.rest;

import com.oleksiykovtun.mongorestapp.Api;
import com.oleksiykovtun.mongorestapp.db.InMemorySimpleDb;
import com.oleksiykovtun.mongorestapp.model.User;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The REST service which accesses user data.
 */
@Path(Api.USERS)
public class UserService extends GeneralService {

    @GET
    @Path(Api.GET_ALL)
    @Produces(JSON)
    public Collection getAll() {
        return InMemorySimpleDb.getEntriesByType(User.class);
    }

    @GET
    @Path(Api.GET + "/{id}")
    @Produces(JSON)
    public User get(@PathParam("id") String id) {
        return (User) InMemorySimpleDb.getEntryById(id);
    }

    @PUT
    @Path(Api.ADD)
    @Consumes(JSON)
    public void add(User user) {
        InMemorySimpleDb.addEntry(user);
    }

    @DELETE
    @Path(Api.DELETE + "/{id}")
    public void delete(@PathParam("id") String id) {
        InMemorySimpleDb.deleteEntryById(id);
    }

}
