package zzjp.springboot.controller.player;

import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pllstrobin on 4/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ComponentScan("zzjp.springboot")
public class PlayerControllerFullIntegratonTest {

    @Value("${test.db.initializer.players.size}")
    private Integer playerSize;

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @MockBean
//    private PlayerRepository playerRepositoryMock;

    @Test
    public void ensureThatAllPlayersAreReturnedFromEndpoint() {

        ResponseEntity<String> allPlayersResponse = testRestTemplate.getForEntity("/api/v1/player/", String.class);
        assertThat(allPlayersResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        JsonPath jsonPath = new JsonPath(allPlayersResponse.getBody());
        List<String> names = jsonPath.get("name");
        assertThat(names).isNotNull().hasSize(playerSize);

        List<String> ids = jsonPath.get("id");
        for (String id : ids) {
            assertThat(id).isNullOrEmpty();
        }
    }

}
