package book;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class BookRestWS {
	
	@EJB
	private BookDao bookDao;
	
	@GET
	@Path("/name")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookData> getBooks()  {
		return bookDao.getBookTitles();
	}
}

