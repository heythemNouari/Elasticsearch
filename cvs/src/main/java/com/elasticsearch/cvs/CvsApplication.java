package com.elasticsearch.cvs;

import com.elasticsearch.cvs.dao.CVRepository;
import com.elasticsearch.cvs.model.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CvsApplication {

	@Autowired
	private CVRepository  cvRepository;

	public static void main(String[] args) {

		SpringApplication.run(CvsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CVRepository repository) {
		return (args) -> {
			CV cv = new CV("NOUARI","HEYTHEM","Java");

			repository.save(cv);
		};
	}

}
