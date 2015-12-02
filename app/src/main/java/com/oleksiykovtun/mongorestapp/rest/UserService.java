package com.oleksiykovtun.mongorestapp.rest;

import com.oleksiykovtun.mongorestapp.Api;
import com.oleksiykovtun.mongorestapp.db.DbInstanceProvider;
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
    public Collection getAll() throws Throwable {
        return DbInstanceProvider.getDb().getEntriesByType(User.class);
    }

    @GET
    @Path(Api.GET + "/{id}")
    @Produces(JSON)
    public User get(@PathParam("id") String id) throws Throwable {
        return (User) DbInstanceProvider.getDb().getEntryByIdAndType(id, User.class);
    }

    @PUT
    @Path(Api.ADD)
    @Consumes(JSON)
    @Produces(TEXT)
    public String add(User user) throws Throwable {
        DbInstanceProvider.getDb().addEntryIfNotExists(user);
        return user.getId();
    }

    @DELETE
    @Path(Api.DELETE + "/{id}")
    public void delete(@PathParam("id") String id) throws Throwable {
        DbInstanceProvider.getDb().deleteEntryById(id);
    }

}
