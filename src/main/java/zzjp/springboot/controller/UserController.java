package zzjp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zzjp.springboot.model.User;
import zzjp.springboot.repository.player.UserRepository;

/**
 * Created by lukasz on 6/7/17.
 */
@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {

        return userRepository.saveAndFlush(user);
    }


}
