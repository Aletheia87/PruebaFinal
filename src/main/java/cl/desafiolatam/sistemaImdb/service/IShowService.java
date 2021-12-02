package cl.desafiolatam.sistemaImdb.service;

import java.util.List;

import cl.desafiolatam.sistemaImdb.model.Show;

public interface IShowService {

	public Show findShowById(Long id);
	public List<Show> findAllShows();	
	public void saveShow(Show show);
	public void updateShow(Show show);
	public void deleteShow(Long id);

}
