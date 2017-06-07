package zzjp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;
import zzjp.springboot.model.Player;
import zzjp.springboot.model.User;
import zzjp.springboot.repository.player.PlayerRepository;
import zzjp.springboot.repository.player.UserRepository;

import java.util.Arrays;

@SpringBootApplication
@EnableAsync
@EnableMBeanExport
@EnableCaching
public class DartsApplication implements CommandLineRunner{

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Qualifier("customEncoder")
	private PasswordEncoder encoder;

	public static void main(String[] args) {

		SpringApplication.run(DartsApplication.class, args);
	}

//	@Bean
//	public CacheManager cacheManager() {
//		// configure and return an implementation of Spring's CacheManager SPI
//		SimpleCacheManager cacheManager = new SimpleCacheManager();
//		cacheManager.setCaches
//				(Arrays.asList(new ConcurrentMapCache("allPlayersCache")));
//		return cacheManager;
//	}

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


		User user = new User();
		user.setPassword(encoder.encode("pass1"));
		user.setUsername("user1");

		userRepository.saveAndFlush(user);

	}
}
