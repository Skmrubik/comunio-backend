package com.example.back_simulador_comunio.services;

import com.example.back_simulador_comunio.entities.JornadasAcumuladas;
import com.example.back_simulador_comunio.entities.Partido;
import com.example.back_simulador_comunio.entities.Resultado;
import com.example.back_simulador_comunio.repositories.JornadasAcumuladasRepository;
import com.example.back_simulador_comunio.repositories.PuntosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JornadasAcumuladasService {

    @Autowired
    PuntosRepository puntosRepository;

    @Autowired
    JornadasAcumuladasRepository jornadasAcumuladasRepository;

    @Autowired
    ControllerPartidoService controllerPartidoService;

    @Autowired
    JornadasAcumuladasTransaccional jornadasAcumuladasTransaccional;

    @PostMapping("/insertPartido")
    public ResponseEntity<Resultado> insertPartido(@RequestBody Partido partido) {
        try {
            System.out.println("1");
            Resultado result = controllerPartidoService.generarResultadoPartido(partido);
            System.out.println("2");
            JornadasAcumuladas jornadaAcumulada = controllerPartidoService.generarPartido(partido, result);
            System.out.println("3");
            jornadasAcumuladasRepository.save(jornadaAcumulada);
            System.out.println("4");
            Resultado resultadoPuntos = controllerPartidoService.generarPuntosPartido(puntosRepository, partido, result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPartidosJornada")
    private ResponseEntity<List<JornadasAcumuladas>> getJornada(@RequestParam String numJornada){
        try {
            System.out.println("Service: "+jornadasAcumuladasRepository);
            Integer num = Integer.parseInt(numJornada);
            List<JornadasAcumuladas> partidos = jornadasAcumuladasRepository.findPartidosByNumJornada(num);
            return new ResponseEntity<>(partidos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPartidoJornada")
    private ResponseEntity<JornadasAcumuladas> getPartidoJornada(@RequestParam String numJornada,
                                                                 @RequestParam String idEquipoLocal){
        try {
            //System.out.println(jornadasAcumuladasRepository);
            Integer num = Integer.parseInt(numJornada);
            Integer idE = Integer.parseInt(idEquipoLocal);
            JornadasAcumuladas partido = jornadasAcumuladasRepository.findPartidoByNumJornadaAndEquipo(num, idE);
            return new ResponseEntity<>(partido, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/borrarTodosDocumentosJornadas")
    private ResponseEntity<Integer> borrarTodosDocumentos(){
        try {
            jornadasAcumuladasTransaccional.borrarTodasJornadas();
            return new ResponseEntity<>(1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
