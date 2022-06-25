package pl.backendapp.backendapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserDataRepository repoData;

    @Autowired
    private SendRepository repoSend;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("maciej@mail.com");
        user.setLogin("Maciej");
        user.setPassword("maciej123");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId_users());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail()) ;
    }

    @Test
    public void testUserData(){
        UserData userData = new UserData();
        userData.setFirstName("Tomasz");
        userData.setLastName("Nowak");
        userData.setAddress("ul. Długa 43");
        userData.setCity("Kraków");
        userData.setPost_code("31-586");
        userData.setPhone("671538429");

        UserData savedUserData = repoData.save(userData);

        UserData existUserData = entityManager.find(UserData.class, savedUserData.getId_users_data());

        assertThat(existUserData.getId_users_data()).isEqualTo(userData.getId_users_data()) ;

    }


    @Test
    public void testFindUserByEmail(){
        String login = "Kasia";
        User user = repo.findByLogin(login);

        assertThat(user).isNotNull();
    }

    @Test
    public void testSendPackage(){
        Send send = new Send();
        send.setUsers_users_details_id_users_details("1");
        send.setGetUsers_users_details_id_users_details1("2");
        send.setDelivery_man_id_delivery_man("1");

        Send savedSend = repoSend.save(send);
    }
}
