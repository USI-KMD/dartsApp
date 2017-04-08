package zzjp.springboot.repository.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zzjp.springboot.model.Player;

import java.util.List;


/**
 * Created by pllstrobin on 4/3/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
// to switch off transactionality of tests add the NOT_SUPPORTED propagation type
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ActiveProfiles("test")
@Sql("classpath:init-schema.sql")
public class PlayersRepositoryTest {

    @Value("${test.db.initializer.players.size}")
    private Integer playerSize;

    @Autowired
    private PlayerRepository playerRepository;

    // this bean cannot be autowired because @DataJpaTest does not create this bean
//    @Autowired
//    private PlayerService playersService;

    @Test
//    @Sql("classpath:init-schema.sql")
//    @Transactional
    public void testFindAll() {
        List<Player> all = playerRepository.findAll();

        System.out.println();

    }

    @Test
    public void testAddPlayer() {
        Player player1 = new Player();
        player1.setName("name111");
        player1.setAge(111);
        playerRepository.saveAndFlush(player1);

        List<Player> all = playerRepository.findAll();

        System.out.println();
    }

    @Test
    public void testFindAll2() {
        List<Player> all = playerRepository.findAll();

        System.out.println();

    }

}
