package com.krakedev.inventario1.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventario1.bdd.ProductosBDD;
import com.krakedev.inventario1.entidades.Producto;
import com.krakedev.inventario1.excepciones.KrakedevException;

@Path("productos")
public class ServiciosProductos {

	@Path("buscar/{subc}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subc") String subCadena) {
		ProductosBDD prod = new ProductosBDD();
		ArrayList<Producto> productos = null;
		try {
			productos = prod.buscar(subCadena);
			return Response.ok(productos).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}