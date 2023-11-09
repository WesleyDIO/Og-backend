package og.net.api.repository;

import og.net.api.model.entity.Equipe;
import og.net.api.model.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
}
