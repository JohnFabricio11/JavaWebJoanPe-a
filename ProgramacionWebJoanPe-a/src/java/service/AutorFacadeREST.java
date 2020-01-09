/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelos.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author usuario
 */
@Stateless
@Path("modelos.autor")
public class AutorFacadeREST extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "ProgramacionWebJoanPe-aPU")
    private EntityManager em;

    public AutorFacadeREST() {
        super(Autor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Autor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Autor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Autor find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> findAll() {
        return super.findAll();
    }

    @POST
    @Path("post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> obtnerTodos() {
        return super.findAll();
    }
    @POST
    @Path("obtenerAutor")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Autor obtnerAutor(@FormParam("id_autor") Integer id){
        return super.find(id);
    }
    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String crearAutor(@FormParam("id_autor") Integer id,@FormParam("nombreAutor") String nombre){
        Autor autor = new Autor();
            autor.setIdAutor(id);
            autor.setNombreAutor(nombre);
            super.create(autor);
        return "Creado";
    }
    @POST
    @Path("edit")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String editAutor(@FormParam("id_autor") Integer id,@FormParam("nombreAutor") String nombre){
        Autor autor;
            autor = super.find(id);
            autor.setIdAutor(id);
            autor.setNombreAutor(nombre);
            super.edit(autor);
        return "editado";
    }
    @POST
    @Path("delete")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String deleteAutor(@FormParam("id_autor") Integer id){
        Autor autor;
            autor = super.find(id);
            autor.setIdAutor(id);
            super.remove(autor);
        return "eliminado";
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
