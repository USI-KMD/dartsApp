package zzjp.springboot.controller.player;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import zzjp.springboot.controller.PlayerController;
import zzjp.springboot.repository.player.PlayerRepository;

/**
 * Created by lukasz on 3/28/17.
 */
public class PlayerControllerTest {

    @Mock
    PlayerRepository playerRepository;

    @InjectMocks
    PlayerController sut;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyControllerCalled() {
        // ... stub
        System.out.println();
    }




}