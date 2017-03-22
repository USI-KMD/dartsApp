package zzjp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.PlayerRepository;

import java.util.List;

/**
 * Created by lukasz on 3/22/17.
 */
@RestController
@RequestMapping("api/v1/players/")
public class PlayersController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(value= "", method = RequestMethod.GET)
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @RequestMapping(value= "create", method = RequestMethod.POST)
    public Player createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerRepository.saveAndFlush(player);
        return savedPlayer;
    }

}
