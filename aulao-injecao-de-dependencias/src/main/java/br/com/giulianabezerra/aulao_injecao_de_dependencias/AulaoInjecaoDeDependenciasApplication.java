package br.com.giulianabezerra.aulao_injecao_de_dependencias;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AulaoInjecaoDeDependenciasApplication {

    	public static void main(String[] args) {	
		   SpringApplication.run(AulaoInjecaoDeDependenciasApplication.class, args);
		
	}

	@Bean
	ApplicationRunner runner(MigracaoUsuario migracaoUsuario) {
		return args -> {
			migracaoUsuario.migrar();
		};
	}

	}

@Component
class MigracaoUsuario {
	Reader<User> reader; 
	Writer<User> writer;


	public MigracaoUsuario(Reader<User> reader, Writer<User> writer) {
		this.reader = reader;
		this.writer = writer;
	}


	void migrar() {
		// Ler usuários de A
		List<User> users = reader.read();
		// Escrever usuários em B
		writer.write(users);
	}
}

record User(String email, String username, String password) {
}


interface Reader<T> {
	List<T> read();
}

interface Writer<T> {
	void write(List<T> itens);
}	

@Component
class FileReader implements Reader<User> {
	public List<User> read() {
		System.out.println("");
		System.out.println("Lendo usuários de um arquivo...");
		return List.of(new User("email","username", "password"));
	}
}

@Component
class BdWriter implements Writer<User> {
	
	public void write(List<User> itens) {
		System.out.println("Escrevendo usuários em um banco de dados...");
		for (User user : itens) {
			System.out.println("Usuário: " + user.username());
		}
	}
}