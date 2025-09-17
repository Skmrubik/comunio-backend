package com.example.back_simulador_comunio.config;

import com.example.back_simulador_comunio.entities.Participante;
import com.example.back_simulador_comunio.entities.User;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;
import com.example.back_simulador_comunio.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired private ParticipanteRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Participante> userRes = userRepo.findByNickname(username);

        if(userRes.isEmpty())
            throw new UsernameNotFoundException("No user found with this username "+username);
        Participante user = userRes.get();
        return new
                org.springframework.security.core.userdetails.User(
                        username,
                        user.getPassword(),
                        Collections.singletonList(
                                new SimpleGrantedAuthority("ROLE_USER")
                        )
        );
    }
}