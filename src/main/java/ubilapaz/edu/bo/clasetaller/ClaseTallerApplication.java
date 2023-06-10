package ubilapaz.edu.bo.clasetaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClaseTallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaseTallerApplication.class, args);
	}

	@Bean
	public String saluda(){
		System.out.println("Hola Mundo");
		return "";
	}

}
