package pl.backendapp.backendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsServices implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{

        User user = repo.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Użytkownik nie znaleziony");
        }
        return (UserDetails) new CustomUserDetails(user);
    }
}
