package zzjp.springboot.controller.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import zzjp.springboot.model.Player;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pllstrobin on 4/4/17.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class PlayerControllerJsonMapperTest {

    @Autowired
    private JacksonTester<Player> playerJsonTester;


    @Test
    public void testSerialize() throws Exception {
        Player player = new Player();
        player.setAge(123);
        player.setName("name1");
        player.setId(123l);

        File expectedPlayer = new ClassPathResource("expected-player.json").getFile();
        JsonContent<Player> converted = this.playerJsonTester.write(player);
        assertThat(converted).isEqualToJson(expectedPlayer, JSONCompareMode.STRICT);
    }


}
