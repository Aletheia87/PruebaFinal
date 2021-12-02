package cl.desafiolatam.sistemaImdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaImdb.dao.ShowRepository;
import cl.desafiolatam.sistemaImdb.model.Show;

@Service
public class ShowService implements IShowService{
	
	@Autowired
	private ShowRepository showRepository;
	
	@Override
	public Show findShowById(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Show> findAllShows() {
		return showRepository.findAll();
		
	}
	
	@Override
	public void saveShow(Show show) {
		showRepository.save(show);
		
	}
	
	@Override
	public void updateShow(Show show) {
		showRepository.save(show);
		
	}
	
	@Override
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
		
	}

}