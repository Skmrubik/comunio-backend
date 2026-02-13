package com.example.back_simulador_comunio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication(scanBasePackages = {"com.example.back_simulador_comunio"})
public class BackSimuladorComunioApplication {

	public static void main(String[] args) {

        SpringApplication.run(BackSimuladorComunioApplication.class, args);

	}

}
