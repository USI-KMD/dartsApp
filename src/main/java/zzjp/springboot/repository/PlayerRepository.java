package zzjp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zzjp.springboot.model.Player;

/**
 * Created by lukasz on 3/22/17.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
