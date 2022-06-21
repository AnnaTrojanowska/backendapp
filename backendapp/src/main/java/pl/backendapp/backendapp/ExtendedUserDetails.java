package pl.backendapp.backendapp;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public interface ExtendedUserDetails extends org.springframework.security.core.userdetails.UserDetails {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getLogin();

    String getEmail();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEneabled();
}
