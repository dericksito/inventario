package com.krakedev.inventario1.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventario1.bdd.TipoDocumentosBDD;
import com.krakedev.inventario1.entidades.TipoDocumentos;
import com.krakedev.inventario1.excepciones.KrakedevException;
@Path("tiposdocumentos")
public class ServiciosTipoDocumentos {
	@Path("recuperar")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response recuperarTd(){
		TipoDocumentosBDD td = new TipoDocumentosBDD();
		ArrayList<TipoDocumentos> tipoD = null;
		try {
			tipoD = td.recuperar();
			return Response.ok(tipoD).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	   @Path("insertar")
	    @POST
	    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	    public Response insertarTd(TipoDocumentos tipoDocumento) {
	        TipoDocumentosBDD td = new TipoDocumentosBDD();
	        try {
	            td.insertar(tipoDocumento);
	            return Response.ok().build();
	        } catch (KrakedevException e) {
	            e.printStackTrace();
	            return Response.serverError().build();
	        }
	    }
}