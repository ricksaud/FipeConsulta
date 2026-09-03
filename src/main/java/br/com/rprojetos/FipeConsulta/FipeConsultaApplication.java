package br.com.rprojetos.FipeConsulta;

import br.com.rprojetos.FipeConsulta.models.Marca;
import br.com.rprojetos.FipeConsulta.principal.Principal;
import br.com.rprojetos.FipeConsulta.services.ConsumoApi;
import br.com.rprojetos.FipeConsulta.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FipeConsultaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeConsultaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibirMenu();

	}
}
