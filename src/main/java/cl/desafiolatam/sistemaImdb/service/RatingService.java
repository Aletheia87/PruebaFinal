package cl.desafiolatam.sistemaImdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaImdb.dao.RatingRepository;
import cl.desafiolatam.sistemaImdb.model.Rating;

@Service
public class RatingService implements IRatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
		
	}
	
	@Override
	public Rating findRatingById(Long id) {
		return ratingRepository.findById(id).orElse(null);
		
	}
	
	@Override
	public void addRating(Rating rating) {
		ratingRepository.save(rating);
		
	}	
	
}