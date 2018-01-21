package book;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: BookData
 *
 */
@Entity @IdClass(BookDataId.class)
@Table(name="book")
@XmlRootElement
public class BookData implements Serializable {

	private static final long serialVersionUID = 1L;

	public BookData() {
		super();
	}
	
	@Id
	private String title;
	
	@Id
	private String username;
	
	private String review;
	
	private int rating;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rating;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookData other = (BookData) obj;
		if (rating != other.rating)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookData [title=" + title + ", username=" + username + ", review=" + review + ", rating=" + rating
				+ "]";
	}
}

class BookDataId {
	String title;
	String username;
}
