/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;

/**
 *
 * @author LENOVO
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ventaPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
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
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @POST
    @Path("obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> buscarClientes() {
        return super.findAll();
    }

    @POST
    @Path("hola")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String Message() {
        return ("hola mundo");
    }

    @GET
    @Path("holaNombre")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Holanombre(@QueryParam("n") String nom) {
        return "bienenido:" + nom;
    }

    @GET
    @Path("suma")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String result(@QueryParam("sum1") int num1, @QueryParam("sum2") int num2) {
        int res = num1 + num2;
        return "el resultado es: " + res;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("mult")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String mult(@FormParam("num1") int num1, @FormParam("num2") int num2) {
        int res = num1 * num2;
        return "El resultado es: " + res;
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idCliente") int idCliente, @FormParam("dni") String dni, @FormParam ("nombres")String nombres, @FormParam ("fechanacimiento") Date fechanacimiento, @FormParam ("direccion") String direccion,@FormParam ("telefono") String telefono){

        return null;
    }

   @POST
   @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idCliente") int idCliente, @FormParam("dni") String dni, @FormParam ("nombres")String nombres, @FormParam ("direccion") String direccion,@FormParam ("telefono") String telefono){
    Cliente ob = super.find(idCliente);
    ob.setDireccion(direccion);
    
    ob.setNombres(nombres);
    ob.setTelefono(telefono);
    super.edit(ob);
        return ("Se actualizo con exito");
    }
    @POST
    @Path ("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("idCliente") int idCliente){
        Cliente ob= super.find(idCliente);
        
//        return ("Se elemino correctamente");
        if (ob == null){
            return ("no se encontro");
        }else{
            super.remove(ob);
            return ("ya se elimino");
        }
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
