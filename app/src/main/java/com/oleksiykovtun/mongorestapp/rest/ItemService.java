package com.oleksiykovtun.mongorestapp.rest;

import com.oleksiykovtun.mongorestapp.Api;
import com.oleksiykovtun.mongorestapp.db.InMemorySimpleDb;
import com.oleksiykovtun.mongorestapp.model.Item;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The REST service which accesses item data.
 */
@Path(Api.ITEMS)
public class ItemService extends GeneralService {

    @GET
    @Path(Api.GET_ALL)
    @Produces(JSON)
    public Collection getAll() {
        return InMemorySimpleDb.getEntriesByType(Item.class);
    }

    @GET
    @Path(Api.GET + "/{id}")
    @Produces(JSON)
    public Item get(@PathParam("id") String id) {
        return (Item) InMemorySimpleDb.getEntryById(id);
    }

    @PUT
    @Path(Api.ADD)
    @Consumes(JSON)
    public void add(Item item) {
        InMemorySimpleDb.addEntry(item);
    }

    @DELETE
    @Path(Api.DELETE + "/{id}")
    public void delete(@PathParam("id") String id) {
        InMemorySimpleDb.deleteEntryById(id);
    }

}
