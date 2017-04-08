package zzjp.springboot.repository.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import zzjp.springboot.model.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pllstrobin on 4/4/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Commit
public class PlayerRepositoryTest2 {

    public static final String
            NAME_FROM_JPA_TESTS = "name-from-JPA-tests";
    public static final int AGE = 10;
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    @Rollback
    public void testFindByName() {
        Player player1 = new Player();
        player1.setName(NAME_FROM_JPA_TESTS);
        player1.setAge(AGE);
        playerRepository.saveAndFlush(player1);

//        List<Player> player0 = playerRepository.findByName(NAME_FROM_JPA_TESTS);
        List<Player> player0 = playerRepository
                .findByNameOrAge("invalid-name", AGE);
//                .findByNameAndAge("invalid-name", AGE);
        assertThat(player0).hasSize(1);

    }

    @Test
    public void testFindXAll() {
        List<Player> all = playerRepository.findAll();
        assertThat(all).hasSize(0);
    }
}
