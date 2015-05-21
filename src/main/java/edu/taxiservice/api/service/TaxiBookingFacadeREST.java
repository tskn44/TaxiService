/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.taxiservice.api.service;

import edu.taxiservice.api.dao.Booking;
import edu.taxiservice.api.dao.Customer;
import edu.taxiservice.api.dao.Taxi;
import edu.taxiservice.api.dao.TaxiBooking;
import edu.taxiservice.api.util.Constants;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Lasitha
 */
@Stateless
@Path("booking")
public class TaxiBookingFacadeREST extends AbstractFacade<TaxiBooking> {

    public TaxiBookingFacadeREST() {
        super(TaxiBooking.class);
    }

    @POST
    @Consumes({"application/json"})
    public void create(Booking booking) {
        Customer customer = getEntityManager().find(Customer.class, booking.getCustomerId());
        Taxi taxi = getEntityManager().find(Taxi.class, booking.getTaxiId());
        
        TaxiBooking tb = new TaxiBooking();
        tb.setCutomerId(customer);
        tb.setTaxiId(taxi);
        create(tb);
    }

    @Override
    public void create(TaxiBooking entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Long id, TaxiBooking entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public TaxiBooking find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<TaxiBooking> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<TaxiBooking> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTANT_UNIT);
        return emf.createEntityManager();
    }

}
