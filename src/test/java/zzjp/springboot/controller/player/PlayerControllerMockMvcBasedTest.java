package zzjp.springboot.controller.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import zzjp.springboot.controller.PlayerController;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.player.PlayerRepository;
import zzjp.springboot.service.PlayerService;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by pllstrobin on 3/31/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest({PlayerController.class, PlayerService.class})
@ActiveProfiles("test")
@ComponentScan
public class PlayerControllerMockMvcBasedTest {

    @Value("${test.db.initializer.players.size}")
    private Integer playerSize;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepository playerRepositoryMock;


    @Test
    public void ensureThatPlayersAreAddedProperly() throws Exception {

        Player player = new Player();
        player.setName("expected-name");
        player.setAge(32);

        Mockito.when(playerRepositoryMock.findAll()).thenReturn(Arrays.asList(player));

        // when we configure the mock to throw the exception we will get exception instead of 500
//        Mockito.when(playerRepositoryMock.findAll()).thenThrow(IllegalStateException.class);

        mockMvc.perform(get("/api/v1/player/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }




}
