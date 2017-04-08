package zzjp.springboot.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.player.PlayerRepository;

import javax.annotation.PostConstruct;

/**
 * Created by pllstrobin on 3/31/17.
 */
@Component
@PropertySource("classpath:application-test.properties")
public class InitializeDatabase {

    @Value("${test.db.initializer.players.size}")
    private Integer playerSize;

    @Autowired
    PlayerRepository playerRepository;

    @PostConstruct
    public void initalizeDB() {
        for (int i = 0; i < playerSize; i++) {
            Player player1 = new Player();
            player1.setName("name" + i);
            player1.setAge(10 + i);
            playerRepository.saveAndFlush(player1);
        }
    }

}
