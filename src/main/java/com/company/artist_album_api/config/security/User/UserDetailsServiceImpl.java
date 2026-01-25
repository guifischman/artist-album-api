package com.company.artist_album_api.security.user;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new UserPrincipal("admin", "{noop}admin123");
    }
}