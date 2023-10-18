package br.com.api.biblioteca;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Anotacao-> determina o papel da classe dentro do spring boot
@SpringBootApplication 
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

@Bean
public ModelMapper modelMapper() {
    return new ModelMapper();
}
}
