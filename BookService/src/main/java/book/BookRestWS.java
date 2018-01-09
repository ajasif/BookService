package book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Hello world!
 *
 */
@Path("/book")
public class BookRestWS {
	
	@GET
	@Path("/name")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBooks()  {
		return "The Wheel of Time";
	}
}

