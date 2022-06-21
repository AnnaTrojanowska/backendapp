package pl.backendapp.backendapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.OffsetDateTime;

public interface UserRepository extends JpaRepository<User, Long> {

   /* @Query(value = "SELECT u FROM users u WHERE u.email=?1")*/
    User findByLogin(String login);
}
