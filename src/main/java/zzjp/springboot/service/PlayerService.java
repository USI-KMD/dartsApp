package zzjp.springboot.service;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zzjp.springboot.cache.CacheConstants;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.player.PlayerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

/**
 * Created by pllstrobin on 3/31/17.
 */
@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Transactional
    @Cacheable(CacheConstants.PLAYERS_CACHE)
    public List<Player> findAllPlayers() {

        return playerRepository.findAll();
    }

    @Transactional
    public Player addRandomPlayer() {

        Player player1 = new Player();
        Integer randomInt = new Random(System.currentTimeMillis()).nextInt(1000);
        player1.setName("name-" + randomInt);
        player1.setAge(randomInt);
        Player player = playerRepository.saveAndFlush(player1);

        return player;
    }

    public Player save(Player player) {
        return playerRepository.saveAndFlush(player);
    }
}
