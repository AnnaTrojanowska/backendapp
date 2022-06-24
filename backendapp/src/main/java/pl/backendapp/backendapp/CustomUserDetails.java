package pl.backendapp.backendapp;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class CustomUserDetails implements ExtendedUserDetails {

    private UserData userData;
    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public String getLogin() {
        return user.getLogin();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isEneabled() {
        return true;
    }



    public String getFullName(){
        return user.getLogin() +"!";
    }


}
