package br.com.claro;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaroCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaroCadastroApplication.class, args);
		
		Locale setLocale = new Locale("br", "Brazil");
	}

}
