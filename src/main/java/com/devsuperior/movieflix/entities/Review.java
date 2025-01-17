package com.devsuperior.movieflix.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_review")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "tb_review_user",
//	    joinColumns = @JoinColumn(name = "user_id"),
//	    inverseJoinColumns = @JoinColumn(name = "review_id"))
//	List<User> user = new ArrayList<>();
//	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "tb_review_movie",
//	    joinColumns = @JoinColumn(name = "movie_id"),
//	    inverseJoinColumns = @JoinColumn(name = "review_id"))
//	List<Movie> movie = new ArrayList<>();
//	

	public Review() {
	}

	public Review(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//
	public Movie getMovie() {
		return movie;
	}
//
//	public void setMovie(List<Movie> movie) {
//		this.movie = movie;
//	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
