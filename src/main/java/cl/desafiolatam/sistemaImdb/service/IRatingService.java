package cl.desafiolatam.sistemaImdb.service;

import java.util.List;

import cl.desafiolatam.sistemaImdb.model.Rating;

public interface IRatingService {

	public List<Rating> findAllRatings();	
	public Rating findRatingById(Long id);
	public void addRating(Rating rating);

}
