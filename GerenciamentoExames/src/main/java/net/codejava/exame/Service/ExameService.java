package net.codejava.exame.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.exame.Modelo.Exame;
import net.codejava.exame.Repository.ExameRepository;

@Service // Avisa o Spring que a classe irá manter a lógica de negócios e adiciona ao AppContext
public class ExameService {
	
	@Autowired // Spring injetar uma instancia automaticamente
	private ExameRepository repo;
	
	public List<Exame> listAll() {
		return (List<Exame>) repo.findAll();
	}
	
	public String save(Exame exame) {

		String status = "1";
		
		try { // Verificar se a data que o usuário digitou é maior que a data de hoje
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dataUsuario = dataFormat.parse(exame.getData().replace('/', '-'));
			Date dataAtual = new Date();
			
			if (dataUsuario.before(dataAtual)) {
				status = "Data do usuário menor que a data de hoje.";
				return status;
			}	
		} catch (Exception e) {
			status = e.getLocalizedMessage();
			return status;
		}
		
		try { // Salva no Banco de Dados
			repo.save(exame);
		}
		catch (Exception e) { // Exception caso o nome já exista
			status = e.getLocalizedMessage();
		}		
		return status;
	}

	public Exame get(long id) {
		Optional<Exame> resultado =  repo.findById(id);
		return resultado.get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Exame> search(String keyword) {
		return repo.search(keyword);
	}
}
