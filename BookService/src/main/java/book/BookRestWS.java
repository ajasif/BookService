package book;

import java.util.List;

import javax.ejb.EJB;
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

@Path("/book")
public class BookRestWS {
	
	@EJB
	private BookDao bookDao;
	
	@GET
	@Path("/all-reviews")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookData> getAllBookReviews()  {
		return bookDao.getAllBookReviews();
	}
	
	@GET
	@Path("/review/{title}/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookReview(@PathParam("title") String title,
							      @PathParam("user") String username) {
		return Response.ok().entity(bookDao.getBookReview(title, username)).build();
	}
	
	@POST
	@Path("/add-review")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBookReview(BookData bookData) {
		if (bookData == null) {
			return Response.status(400).entity("Please add review details!").build();
		}
		if (bookData.getTitle() == null || bookData.getUsername() == null) {
			return Response.status(400).entity("Please add book title and username!").build();
		}
		bookDao.addReview(bookData);
		String output = "POST: Added a book review to the database!";
		return Response.status(200).entity(output).build();
	}
	
	@PUT
	@Path("/update-review")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBookReview(BookData bookData) {
		if (bookData == null) {
			return Response.status(400).entity("Please add review details!").build();
		}
		if (bookData.getTitle() == null || bookData.getUsername() == null) {
			return Response.status(400).entity("Please add book title and username!").build();
		}
		bookDao.updateReview(bookData);
		String output = "POST: Added a book review to the database!";
		return Response.status(200).entity(output).build();
	}
	
	@DELETE
	@Path("/delete-review/{title}/{user}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public Response deleteBookReview(@PathParam("title") String title,
		      @PathParam("user") String username) {
		bookDao.deleteReview(title, username);
		String output = "Delete: Deleted a book review from the database!";
		return Response.status(200).entity(output).build();
	}
}





