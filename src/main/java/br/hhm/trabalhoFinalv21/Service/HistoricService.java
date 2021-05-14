package br.hhm.trabalhoFinalv21.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hhm.trabalhoFinalv21.Models.Historic;
import br.hhm.trabalhoFinalv21.Repositories.HistoricRepo;

@Service
public class HistoricService {
	private final HistoricRepo historicRepo;
	
	
	@Autowired
	public HistoricService(HistoricRepo historicRepo) {
		this.historicRepo = historicRepo;
	}
	
	public Historic addHistoric(Historic historic) {
		return historicRepo.save(historic);
	}
	
	public Historic addHistoricRandom() {
		Historic historic = new Historic();
		historic.setName("User#" + (int)Math.floor(Math.random()*(999-1+1)+1));
		historic.setTime((int)Math.floor(Math.random()*(200-1+1)+1));
		historic.setEnergy((int)Math.floor(Math.random()*(200-1+1)+1));
		historic.setCost((int)Math.floor(Math.random()*(200-1+1)+1));
		return historicRepo.save(historic);
	}
	
	public List<Historic> listAllHistoric(){
		return historicRepo.findAll();
	}
	
	public Historic updateHistoric(Historic historic) {
		return historicRepo.save(historic);
	}
	
	public void deleteHistoric(Long id) {
		historicRepo.deleteById(id);
	}

}
