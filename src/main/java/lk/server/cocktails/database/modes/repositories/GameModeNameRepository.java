package lk.server.cocktails.database.modes.repositories;

import lk.server.cocktails.database.modes.entities.GameModeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameModeNameRepository extends JpaRepository<GameModeName, Long> {

}
