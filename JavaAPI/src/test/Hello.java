package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@SuppressWarnings("unused")
@Path("/hello")
// With respect to my project URL if I put 
// /hello it should go into this location
/*
 *  @Path used before the class will send your URI to the class
 * while it is used before your method, it will guide your 
 * HTTP request to your method.  This will allow URL strings
 * to be used inside your method.
 */

/*
 * @GET - Most used, read-only and public access method
 * @POST - Used to insert/add data OR submitting data like
 * Login pages.  with HTTPS you can protect the data
 * @PUT - Used mainly for updating data but can be used for 
 * inserting/adding data
 * @DELETE - Used to delete data
 * @HEAD - Used to return meta-data of the resource
 * @PRODUCES - Specifies the media type that a method will 
 * produce and send back to the client.
 * @Consumes - Tells your application to expect data to be
 * sent in the body of the HTTP message.  You will need to define 
 * what type of data is sent up, and this can limit what HTTP
 * message can access specific methods.  
 *  ** In a GIT request, it must be included in the HTML parameters
 *  -- Connecting to a database using DB connection
 *  
 */

public class Hello {

	@GET
	// This gets the resource.  This takes in an
	// input from the user
	@Produces(MediaType.TEXT_XML)
	public String sayHello()
	{
		String resource="<? xml version='1.0' ?>" + "<hello> Hi Chris, This is Hello from XML</hello>";
		
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJASON()
	{
		String resource=null;
		return resource;
	}
	
	/*
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML()
	{
		String resource="<h1> Hi Chris, this is Hello from HTML</h1>";
		return resource;
	}
	*/
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayhelloHTML(@QueryParam("name") String name, @QueryParam("Card_no") String Card_no, @QueryParam("amount") int amount) {
		System.out.println("Name is "+name);
		System.out.println("Amount is "+amount);
		String response;
		
		if(amount>100000)
		{
				System.out.println("Amount is Greater than 1 dollar");
				response = "Credit Card is not approved";
		}
		else
		{
			
			System.out.println("Amount is Less than 1 dollar");
			response = "Credit card is approved";
			}
		return "<html>" + "<title>" +"Credit Card Authorization" + name + "</title>" + "<body><h1>" + response + "</h1></body>" + "</html>";
		// These are sample parameters you can pass through in an HTML
		// ?name= Chris&Card_no=12345&amount=10000
	}
	}  
