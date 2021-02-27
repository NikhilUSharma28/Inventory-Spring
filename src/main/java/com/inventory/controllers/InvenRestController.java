package com.inventory.controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.inventory.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.inventory.service.InvenService;


@Path("/product")
public class InvenRestController {
	@Autowired
	InvenService invenService;

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory> getProducts() throws DataAccessException, IOException {
		List<Inventory> list = invenService.getAll();
		return list;
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory> save(Inventory inventory) throws DataAccessException, IOException {
		invenService.save(inventory);
		return getProducts();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory> updateProduct(Inventory inventory) throws DataAccessException, IOException {
		invenService.update(inventory);
		return getProducts();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory> deleteProduct(@PathParam("id") int id) throws DataAccessException, IOException {
		invenService.delete(id);
		return getProducts();
	}
}
