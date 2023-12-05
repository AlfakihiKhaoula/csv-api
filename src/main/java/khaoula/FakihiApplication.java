package khaoula;

import khaoula.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FakihiApplication implements CommandLineRunner {
	@Autowired
	private ProduitService service;

	public static void main(String[] args) {
		SpringApplication.run(FakihiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.loadProduitsFromCSV();
	}

}
