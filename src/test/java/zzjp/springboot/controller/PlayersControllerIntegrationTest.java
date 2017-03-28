package zzjp.springboot.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.PlayerRepository;

import java.util.List;

/**
 * Created by lukasz on 3/28/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlayersControllerIntegrationTest {

    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void testFindAll() {
        List<Player> all = playerRepository.findAll();
        Assertions.assertThat(all)
                .isNotNull()
                .isEmpty();

    }



}
