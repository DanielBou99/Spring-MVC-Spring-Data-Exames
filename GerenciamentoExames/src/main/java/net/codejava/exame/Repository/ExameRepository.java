package net.codejava.exame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.exame.Modelo.Exame;

public interface ExameRepository extends CrudRepository<Exame, Long>{

	@Query(value = "SELECT c FROM Exame c WHERE c.nome LIKE '%' || :keyword || '%'"
		+ " OR c.exame LIKE '%' || :keyword || '%'"
		+ " OR c.observacao LIKE '%' || :keyword || '%'"
		+ " OR c.data LIKE '%' || :keyword || '%'")
	public List<Exame> search(@Param("keyword") String keyword); //@Param para usar o parâmetro na query
}
