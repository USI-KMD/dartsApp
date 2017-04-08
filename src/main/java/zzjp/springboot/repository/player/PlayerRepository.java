package zzjp.springboot.repository.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zzjp.springboot.model.Player;

import java.util.List;

/**
 * Created by lukasz on 3/22/17.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByName(String name);

    List<Player> findByNameOrAge(String name, Integer age);

    List<Player> findByNameAndAge(String name, Integer age);

}
