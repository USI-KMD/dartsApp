package zzjp.springboot.repository.player;


import org.springframework.data.jpa.repository.JpaRepository;
import zzjp.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}