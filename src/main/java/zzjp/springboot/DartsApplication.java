package zzjp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import zzjp.springboot.model.Player;
import zzjp.springboot.repository.player.PlayerRepository;

@SpringBootApplication
@EnableAsync
public class DartsApplication implements CommandLineRunner{

	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {

		SpringApplication.run(DartsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Player player1 = new Player();
		player1.setName("ADMIN");
		player1.setSurname("ADMIN");

		playerRepository.saveAndFlush(player1);

		Player player2 = new Player();
		player2.setName("User1");
		player2.setSurname("User1");

		playerRepository.saveAndFlush(player2);



	}
}
