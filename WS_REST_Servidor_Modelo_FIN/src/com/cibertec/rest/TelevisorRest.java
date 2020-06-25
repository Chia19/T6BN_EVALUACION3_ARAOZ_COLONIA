package com.cibertec.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.cibertec.dao.TelevisorDAOImpl;
import com.cibertec.entidad.Televisor;

@Path("/televisor")
public class TelevisorRest {
	private TelevisorDAOImpl dao;
	
	public TelevisorRest() {
		dao=new TelevisorDAOImpl();
	}
	
	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarTelevisor(Televisor bean) {
		return dao.saveTelevisor(bean);
	}
	
	@GET
	@Path("/consulta/{can1}/{can2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaTelevisor(@PathParam("can1") int c1,@PathParam("can2") int c2){
		return  Response.ok(dao.listAllTelevisorXStock(c1, c2)).build();
	}
}



