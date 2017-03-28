package zzjp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zzjp.springboot.configuration.MyBean;
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

    @Autowired
    private MyBean myBean;

    @RequestMapping(value= "", method = RequestMethod.GET)
    public List<Player> findAll() {

        System.out.println();
        return playerRepository.findAll();
    }

    @RequestMapping(value= "create", method = RequestMethod.POST)
    public Player createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerRepository.saveAndFlush(player);
        return savedPlayer;
    }

    @RequestMapping(value = "testnum", method = RequestMethod.GET)
    public void testPlayer(@RequestParam(value="someint", required = false) Integer num) {

        System.out.println(num);
    }

}
