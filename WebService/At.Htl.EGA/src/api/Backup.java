package api;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import db.ConnectionFactory;
import domains.Calendar;

@Path("/backup")
public class Backup {
	
	private Connection 		Con 		= null;
	private String			ConType 	= "mysql";
	
	public Backup() {
		Con = ConnectionFactory.get(ConType);
	}
	
	
	//Update backup
	@PUT
	@Path("/{calendarId}")
	public Response UpdateBackup(@PathParam("calendarId") int calendarId) {
		//delete
		return Response.status(200).entity("sick").build(); 
	}
	
	
	//Delete backup
	@DELETE
	@Path("/{calendarId}")
	public Response  DeleteBackup(@PathParam("calendarId") int calendarId, Calendar c) {
		//delete
		return Response.status(200).entity("sick").build(); 
	}
	
	
	//Get all backups
	@GET
	  @Path("/")
	  @Produces({ MediaType.TEXT_HTML, MediaType.APPLICATION_JSON })
	  public Response GetCalendarBackups() {  
		  //get from db
		  return Response.status(200).entity("sick").build(); 
	  }
	
	//Get backup
	  @GET
	  @Path("/{calendarId}")
	  @Produces({ MediaType.TEXT_HTML, MediaType.APPLICATION_JSON })
	  public Response GetCalendarBackup(@PathParam("calendarId") int calendarId) {  
		  //get from db
		  return Response.status(200).entity("sick").build(); 
	  }
	  
	  //Make backup
	  @POST 
	  @Path("/")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public Response MakeCalendarBackup(EventList events) {   
		  //parse and safe to db
			return Response.status(200).entity("sick").build();  
	  }
}
