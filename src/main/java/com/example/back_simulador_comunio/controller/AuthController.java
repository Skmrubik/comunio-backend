package com.example.back_simulador_comunio.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.config.JWTUtil;
import com.example.back_simulador_comunio.entities.LoginCreds;
import com.example.back_simulador_comunio.entities.Participante;
import com.example.back_simulador_comunio.entities.User;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;
import com.example.back_simulador_comunio.repositories.UserRepo;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> registerHandler(
            @RequestBody User user
            ){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = userRepo.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return Collections.singletonMap("jwt_token",token);
    }

    @PostMapping("/registerParticipante")
    public Map<String, Object> registerHandlerParticipante(
            @RequestBody Participante user
            ){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        Participante participante = new Participante();
        participante.setNickname(user.getNickname());
        participante.setPassword(encodedPass);
        participante.setIdParticipante(user.getIdParticipante());
        participante.setJugadoresJugados(user.getJugadoresJugados());
        participante.setPuntosJornadaActual(user.getPuntosJornadaActual());
        participante.setPuntosTotales(user.getPuntosTotales());
        Participante participanteReturn = participanteRepository.save(participante);

        String token = jwtUtil.generateToken(participanteReturn.getNickname());
        return Collections.singletonMap("jwt_token",token);
    }

    
    @PostMapping("/login")
    public Map<String,Object> loginHandler(
            @RequestBody LoginCreds body
            ){
        try{
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authenticationManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getUsername());
            return Collections.singletonMap("jwt_token",token);
        } catch(AuthenticationException authExc){
            throw new RuntimeException("Invalid username/password.");
        }

    }

}
