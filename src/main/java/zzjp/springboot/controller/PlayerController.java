package zzjp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zzjp.springboot.aspect.Monitored;
import zzjp.springboot.aspect.MonitoringAspect;
import zzjp.springboot.aspect.TracingAspect;
import zzjp.springboot.async.MyAsyncComponent;
import zzjp.springboot.configuration.MyBean;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.player.PlayerRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lukasz on 3/22/17.
 */
@RestController
@RequestMapping("api/v1/player/")
public class PlayerController {

    @Autowired
    private MyAsyncComponent asyncComponent;

    @Autowired
    private MonitoringAspect monitoringAspect;

    @Autowired
    private PlayerRepository playerRepository;

    @Monitored
    @RequestMapping(value= "", method = RequestMethod.GET)
    public List<Player> findAll() throws ExecutionException, InterruptedException {

        System.out.println("starting operations");
        Future<String> addr1 = asyncComponent.accessWebService("addr1");
        Future<String> addr11 = asyncComponent.accessWebService("addr3");
        Future<String> addr3 = asyncComponent.accessWebService("addr3");

        System.out.println("getting results");
        String s = addr1.get();
        System.out.println("s = " + s);
        String s1 = addr11.get();
        System.out.println("s1 = " + s1);
        String s2 = addr3.get();
        System.out.println("s2 = " + s2);




        monitoringAspect.setEnabled(true);

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

//        System.out.println(num);
    }

    @RequestMapping(value = "testnum", method = RequestMethod.DELETE)
    public void deletePlayer(@RequestParam("name") String name) {

//        playerRepository.delete();
    }

}
